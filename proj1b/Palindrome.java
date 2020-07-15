public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            charDeque.addLast(c);
        }
        return charDeque;
    }


    public boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (right > left) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (!cc.equalChars(word.charAt(left), word.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
