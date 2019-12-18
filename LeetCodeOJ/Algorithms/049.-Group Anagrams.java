class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sKey = Arrays.toString(chs);
            if (!map.containsKey(sKey)) {
                map.put(sKey, map.size());
                result.add(new ArrayList<>());
            }
            result.get(map.get(sKey)).add(s);
        }
        return result;
    }
}
