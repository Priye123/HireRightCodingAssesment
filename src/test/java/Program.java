
public class Program {

	public static void main(String[] args) {
		String S="-H-H-H";
		 StringBuilder sb=new StringBuilder(S);
	        for(int i=1;i<S.length()-1;i++){
	            if(sb.charAt(i)=='-' && sb.charAt(i-1)=='H' && sb.charAt(i+1)=='H'){
	                sb.setCharAt(i,'W');
	                sb.setCharAt(i-1,'D');
	                sb.setCharAt(i+1,'D');
	            }
	        }
	        
	        for(int i=0;i<S.length();i++) {
	        	if(sb.charAt(i)=='H') {
	        		if(i-1 >=0 && sb.charAt(i-1)!='W' && sb.charAt(i-1)=='-') {
	        			sb.setCharAt(i-1, 'W');
	        			sb.setCharAt(i, 'D');
	        		}
	        		else if(i+1<=sb.length()-1 && sb.charAt(i+1)!='W' && sb.charAt(i+1)!='-') {
	        			sb.setCharAt(i+1, 'W');
	        			sb.setCharAt(i, 'D');
	        		}else {
	        			//return -1;
	        		}
	        	}
	        }
	        
	        int count=0;
	        
	        for(int i=0;i<sb.length();i++) {
	        	if(sb.charAt(i)=='W') {
	        		count++;
	        	}
	        	if(sb.charAt(i)=='H') {
	        		//return -1;
	        	}
	        }
	}

}
