package String;

/**

 468. Validate IP Address

 Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

 IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each

 ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

 Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

 IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups

 are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also,

 we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to

 upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

 However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons

 (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

 Besides, extra leading zeros in the IPv6 is also invalid. For example, the address

 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

 Note: You may assume there is no extra space or special characters in the input string.

 Example 1:
 Input: "172.16.254.1"

 Output: "IPv4"

 Explanation: This is a valid IPv4 address, return "IPv4".
 Example 2:
 Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

 Output: "IPv6"

 Explanation: This is a valid IPv6 address, return "IPv6".
 Example 3:
 Input: "256.256.256.256"

 Output: "Neither"

 Explanation: This is neither a IPv4 address nor a IPv6 address.

 */


public class validIPAddress {

    //70%
    public static String validIPAddress(String IP) {
        if(IP.contains(".")){
            String [] nums = IP.split("\\.");
            if(IP.startsWith(".") || IP.endsWith(".") || nums.length != 4)
                return "Neither";
            for(String num : nums){
                if(num.startsWith("0") && !num.equals("0"))
                    return "Neither";
                try{
                    int parseInt = Integer.parseInt(num);
                    if(parseInt < 0 || parseInt > 255) return "Neither";
                    if(parseInt==0 && num.charAt(0)!='0') return "Neither";
                }catch (NumberFormatException nfe) {
                    return "Neither";
                }
            }
            return "IPv4";
        }else if(IP.contains(":")){
            String [] nums = IP.split(":");
            if(IP.startsWith(":") || IP.endsWith(":") || nums.length != 8)
                return "Neither";
            for(String num : nums){
                if(num.length() > 4 || num.equals(""))
                    return "Neither";
                char [] chars = num.toCharArray();
                for(char c : chars){
                    boolean isDigit = c>=48 && c<=57;
                    boolean isUppercaseAF = c>=65 && c<=70;
                    boolean isLowerCaseAF = c>=97 && c<=102;
                    if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                        return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";

    }

    //15%
    public String validIPAddress1(String IP) {
        if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
        return "Neither";
    }

    public static void main(String[] args){
        validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334");
    }
}
