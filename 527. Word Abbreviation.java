/**
 * 527. Word Abbreviation
 * created by Luna1228
 * method: hashmap:remember the abbr to key
                   if is unique: save to the key to abbr map
                   else: add length of prefix
 */

class Solution {
    Map<String, String> map = new HashMap();
    public List<String> wordsAbbreviation(List<String> dict) {
        constructMap(dict, 0);
        List<String> res = new ArrayList();
        for(String word: dict) {
            res.add(map.get(word));
        }
        return res;
    }
    
    public String getAbbr(String word, int fromIndex) {
        int len = word.length();
        if(len - fromIndex <= 3) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, fromIndex+1));
        sb.append(len-fromIndex-2);
        sb.append(word.charAt(len-1));
        return sb.toString();
    }
    
    public void constructMap(List<String> dict, int fromIndex) {
        Map<String, List<String>> ab2word = new HashMap();
        for(String word: dict) {
            String abbr = getAbbr(word, fromIndex);
            ab2word.putIfAbsent(abbr, new ArrayList());
            ab2word.get(abbr).add(word);
        }
        
        for(String abbr: ab2word.keySet()) {
            if(ab2word.get(abbr).size() == 1) {
                map.put(ab2word.get(abbr).get(0), abbr);
            } else {
                constructMap(ab2word.get(abbr), fromIndex+1);
            }
        }
    }
}
