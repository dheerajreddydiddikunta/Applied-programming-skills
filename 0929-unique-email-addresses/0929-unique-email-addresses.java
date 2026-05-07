class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for(String email : emails){
            String parts[] = email.split("@");
			// split it by + sign, if it's not there, it will be ignored, no need to handle
			// e.g. someone+1@gmail.com, someone@gmail.com
            String withOutPlus = parts[0].split("\\+")[0];
			// remove all dots from token, basically it will be normalised word
			// e.g. some.one+1@gmail.com, s.ome.one@gmail.com
            String formatted = withOutPlus.replaceAll("\\.","");
			// append domain name to local name and push it in unique set
            unique.add(formatted + "@" + parts[parts.length - 1]);
        }
		// return the size. it's the answer!
        return unique.size();
    }
}