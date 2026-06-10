export const bubbleSort = (numbers: number[]): void => {
    const n = numbers.length;
    for (let i = 0; i < n - 1; i++) {
        let hasChanged = false;
        for (let j = 0; j < n - i - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                [numbers[j], numbers[j + 1]] = [numbers[j + 1], numbers[j]];
                hasChanged = true;
            }
        }
        if (!hasChanged) break;
    }
}