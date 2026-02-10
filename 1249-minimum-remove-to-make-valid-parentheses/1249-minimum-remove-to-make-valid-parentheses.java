class Solution {
    public String minRemoveToMakeValid(String s) {
        char chars[] = s.toCharArray();

        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < chars.length ; i++)
        {
            if(chars[i] == '(')
            {
                st.push(i);
            }
            else if(chars[i] == ')')
            {
                if(st.size() == 0)
                {
                    chars[i] = '.';
                }
                else
                {
                    st.pop();
                }
            }
        }

        while(st.size() > 0)
        {
            chars[st.pop()] = '.';
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : chars)
        {
            if(ch != '.')
            {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}