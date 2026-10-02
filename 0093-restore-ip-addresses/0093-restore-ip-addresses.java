class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                            String ip, List<String> result) {

        if (parts == 4) {
            if (index == s.length()) {
                result.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            // Value must be <= 255
            if (Integer.parseInt(part) > 255)
                continue;

            backtrack(
                s,
                index + len,
                parts + 1,
                ip + part + ".",
                result
            );
        }
    }
}