export const topKFrequentElements = (nums: number[], k: number): number[] => {
    const result: number[] = [];
    const map = new Map<number, number>();
    const buckets: number[][] = Array.from({ length: nums.length + 1 }, () => []);
    for (const num of nums) map.set(num, (map.get(num) ?? 0) + 1);
    for (const [num, frequency] of map) buckets[frequency].push(num);
    for (let i = buckets.length - 1; i >= 0 && result.length < k; i--) {
        for (const num of buckets[i]) {
            result.push(num);
            if (result.length === k) break;
        }
    }
    return result;
}