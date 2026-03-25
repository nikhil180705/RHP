package RHP;
import java.util.*;

/*
PROBLEM STATEMENT:

Given a string s consisting of lowercase English letters ('a' to 'z').

We define a "good subsequence of length 3" as:
- A subsequence of the form: x y x
- Where the first and third characters are the same.

Your task is to count the total number of such subsequences.

------------------------------------------------------------

EXAMPLE:

Input:
s = "abca"

Subsequences of length 3:
- "aba" → valid
- "aca" → valid

Output:
2

------------------------------------------------------------

APPROACH:

We use two frequency arrays:

1. lt[] → counts of characters to the LEFT of current index
2. rt[] → counts of characters to the RIGHT of current index

Steps:
- Initially fill rt[] with total frequency of all characters
- Traverse string:
    - Remove current character from rt[]
    - For every character 'j':
        count += (lt[j] * rt[j])
    - Add current character to lt[]

Why this works:
For each middle position:
- lt[j] → choices for left 'j'
- rt[j] → choices for right 'j'
So total combinations = lt[j] * rt[j]

------------------------------------------------------------

TIME COMPLEXITY:
O(26 * n) ≈ O(n)

SPACE COMPLEXITY:
O(26)
*/

public class palindrome3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] lt = new int[26];
        int[] rt = new int[26];

        // Count all characters on right side initially
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            rt[ch - 'a']++;
        }

        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // Remove current character from right
            rt[ch - 'a']--;

            // Count all possible x _ x subsequences
            for(int j = 0; j < 26; j++){
                ans += (lt[j] * rt[j]);
            }

            // Add current character to left
            lt[ch - 'a']++;
        }

        System.out.println(ans);
    }
}