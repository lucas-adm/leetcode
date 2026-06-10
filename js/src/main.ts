import { twoSum } from "./c1";
import { isPalindrome } from "./c125";
import { longestConsecutive } from "./c128";
import { topKFrequentElements } from "./c347";
import { reverseOnlyLetters } from "./c917";
import { bubbleSort } from "./none";

const line = (): void => {
    console.log("=".repeat(40));
};

const showArray = (label: string, arr: number[]): void => {
    console.log(`${label.padEnd(12)}: ${JSON.stringify(arr)}`);
};

const showString = (label: string, value: string): void => {
    console.log(`${label.padEnd(12)}: ${value}`);
};

const toP1 = "arara";
const toP2 = "arare";
const toRol = "a1b-c2d-e3f";
const toLcs = [11, 77, 12, 24, 144, 13, 32, 72, 14, 48, 15, 666];
const toTkfe = [1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4];
const toTkfeK = 2;
const toTarget = 13;
const toTs = [2, 7, 11, 15];
const toSort = [7, 5, 3, 1];

line();
showArray("Before bs", toSort);
bubbleSort(toSort);
showArray("After bs", toSort);

line();
console.log(
    `${"Palindrome".padEnd(12)}: ${toP1} -> ${isPalindrome(toP1)}`
);
console.log(
    `${"Palindrome".padEnd(12)}: ${toP2} -> ${isPalindrome(toP2)}`
);

line();
showString("Before rol", toRol);
showString("After rol", reverseOnlyLetters(toRol));

line();
showArray("Input lcs", toLcs);
console.log(`${"LCS result".padEnd(12)}: ${longestConsecutive(toLcs)}`);

line();
showArray("Input tkfe", toTkfe);
console.log(
    `${"Top 2".padEnd(12)}: ${JSON.stringify(topKFrequentElements(toTkfe, toTkfeK))}`
);

line();
showArray("Input ts", toTs);
console.log(`${"Target".padEnd(12)}: ${toTarget}`);

try {
    const result = twoSum(toTs, toTarget);
    console.log(`${"TwoSum".padEnd(12)}: ${JSON.stringify(result)}`);
} catch (error) {
    const message = error instanceof Error ? error.message : String(error);
    console.log(`${"TwoSum".padEnd(12)}: ${message}`);
}

line();