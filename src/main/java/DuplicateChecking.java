public class DuplicateChecking {

    public boolean ExistDuplicate(int[] numarray, int fori) {
        for (int j = 0; j < fori; j++) {
            if (numarray[fori] == numarray[j]) {
                return true;
            }
        }
        return false;
    }
}
