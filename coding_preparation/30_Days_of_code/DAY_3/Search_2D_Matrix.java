class Search_2D_Matrix{
    public boolean Approach1(int[][] matrix,int target){
        // This is optimized brute force approach takes O(M*Q)
        // where is q is the number of query's took place to find the right row 
        if(matrix.length==0)
            return false;
        int row = matrix.length , col = matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=col-1;j>=0;j--){
                if(matrix[i][j] == target)
                    return true;
                if(target > matrix[i][j] || target < matrix[i][0])
                    break;
            }
        }
        return false;
    }

    public boolean Approach2(int[][] matrix,int target){
        // This is efficent approach for finding the element in sorted matrix
        //  time complexity is O(logM+logN)
        int row = matrix.length , col = matrix[0].length;
        int low = 0 , high = row*col-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[mid/col][mid%col] == target)
                return true;
            else if(matrix[mid/col][mid%col] < target)
                low = mid+1;
            else 
                high = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix,int target){
        boolean ans;
        // ans  = Approach1(matrix,target);
        ans  = Approach2(matrix, target);
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix={
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        Search_2D_Matrix SM = new Search_2D_Matrix();
        int search = 16;
        if(SM.searchMatrix(matrix,search))
            System.out.println(search+" Present in matrix");
        else 
        System.out.println(search+" Not Present in matrix");
    }
};