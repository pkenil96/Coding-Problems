class L71SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] dirs = path.split("/");
        for(String dir: dirs){
            if(!stack.isEmpty() && dir.equals("..")){
                stack.pop();
            } else if(dir.equals("..") || dir.equals(".") || dir.length() == 0){
                continue;
            } else {
                stack.push(dir);
            }
        }
        
        while(!stack.isEmpty()){
            sb.insert(0, "/" + stack.pop());
        }
        if(sb.length() == 0)
            sb.append("/");
        return sb.toString();
    }
}