export const longestConsecutive = (nums: number[]): number => {
    let longestStreak = 0;
    const set = new Set<number>(nums);
    for (const num of set) {
        if (!set.has(num - 1)) {
            let currentNum = num;
            let currentStreak = 1;
            while (set.has(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }
    return longestStreak;
}