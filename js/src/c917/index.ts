export const reverseOnlyLetters = (s: string): string => {
    const chars = s.split('');
    let left = 0;
    let right = chars.length - 1;
    while (left < right) {
        if (!/[a-z]/i.test(chars[left])) left++;
        else if (!/[a-z]/i.test(chars[right])) right--;
        else {
            [chars[left], chars[right]] = [chars[right], chars[left]];
            left++;
            right--;
        }
    }
    return chars.join('');
}