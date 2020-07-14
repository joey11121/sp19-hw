public class OffByN implements CharacterComparator {
    int offset;

    OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == offset) {
            return true;
        }
        return false;
    }
}