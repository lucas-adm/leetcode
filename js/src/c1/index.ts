export const twoSum = (nums: number[], target: number): [number, number] => {
    const map = new Map<number, number>();
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        const index = map.get(complement);
        if (index !== undefined) return [index, i];
        map.set(nums[i], i);
    }
    throw new Error('No two numbers sum up to the target.');
}