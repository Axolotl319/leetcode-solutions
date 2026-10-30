class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // can't finish if there is a loop of prerequisite < 0 or >= numCourses
        int n = prerequisites.length;
        if(n <= 0) return true;
        List<List<Integer>> presByCourse = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            List<Integer> pres = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(prerequisites[j][1] == i){
                    pres.add(prerequisites[j][0]);
                }
            }
            presByCourse.add(pres);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(presByCourse.get(i).isEmpty()) continue;
            if(!possible(numCourses, presByCourse, visited, i)){
                return false;
            }
        }
        return true;
    }

    private boolean possible(int numCourses, List<List<Integer>> prerequisites, boolean[] visited, int i){
        if(visited[i]){
            // loop => can't finish
            return false;
        }
        visited[i] = true;
        List<Integer> pres = prerequisites.get(i);
        for(int j = 0; j < pres.size(); j++){
            boolean check = possible(numCourses, prerequisites, visited, pres.get(j));
            if(!check) return false;
            
        }
        visited[i] = false; // backtrack
        return true;
    }
}