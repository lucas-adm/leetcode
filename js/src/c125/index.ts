export const isPalindrome = (s: string): boolean => {
    let left = 0;
    let right = s.length - 1;
    while (left < right) {
        const a = s[left];
        const b = s[right];
        if (!/[a-z0-9]/i.test(a)) left++;
        else if (!/[a-z0-9]/i.test(b)) right--;
        else {
            if (a.toLowerCase() !== b.toLowerCase()) return false;
            left++;
            right--;
        }
    }
    return true;
}