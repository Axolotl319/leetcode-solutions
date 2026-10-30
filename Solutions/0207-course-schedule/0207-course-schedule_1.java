class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // can't finish if there is a loop of prerequisite < 0 or >= numCourses
        int n = prerequisites.length;
        if(n <= 0) return true;
        Set<Integer> hasPrerequisite = new HashSet<>();
        for(int i = 0; i < n; i++){
            hasPrerequisite.add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!hasPrerequisite.contains(i)) continue;
            if(!possible(numCourses, prerequisites, visited, i)){
                return false;
            }
        }
        return true;
    }

    private boolean possible(int numCourses, int[][] prerequisites, boolean[] visited, int i){
        if(visited[i]){
            // loop => can't finish
            return false;
        }
        visited[i] = true;
        for(int j = 0; j < prerequisites.length; j++){
            if(prerequisites[j][1] == i){
                boolean check = possible(numCourses, prerequisites, visited, prerequisites[j][0]);
                if(!check) return false;
            }
        }
        visited[i] = false; // backtrack
        return true;
    }
}