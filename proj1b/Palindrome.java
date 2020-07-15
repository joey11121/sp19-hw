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
        Deque wDeque = wordToDeque(word);
        int l = 0, r = wDeque.size() - 1;
        return isPalinRecur(l,  r, wDeque);
    }

    private boolean isPalinRecur(int left, int right, Deque wordDeque) {
        if (right <= left) {
            return true;
        }
        char a = (char) wordDeque.removeFirst();
        char b = (char) wordDeque.removeLast();
        if ((a - b) != 0) {
            return false;
        }
        return isPalinRecur(left + 1, right - 1, wordDeque);
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
