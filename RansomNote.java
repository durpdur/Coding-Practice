import java.util.HashMap;

class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0));
            int currVal = magazineMap.get(c) + 1;
            magazineMap.put(c, currVal);
        }

        for (char cRansom : ransomNote.toCharArray()) {

            if (magazineMap.get(cRansom) == null || magazineMap.get(cRansom) == 0) {
                return false;
            }

            int currVal = magazineMap.get(cRansom) - 1;
            magazineMap.put(cRansom, currVal);
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "blahdslnb";
        String magazine = "blaha";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}