public class RottenPotato {

    public static void main(String[] args) {

        int[][] ratings = { {4,6,2,5},
                            {7,9,4,8},
                            {6,9,3,7} };

        System.out.println("Movie zero's average rating: " + movieAvgRating(ratings, 0));                    
        System.out.println("Movie one's average rating: " + movieAvgRating(ratings, 1));    
        System.out.println("Reviewer zero's average rating: " + reviewerAvgRating(ratings, 0));    
        System.out.println("Reviewer one's average rating: " + reviewerAvgRating(ratings, 1));
        System.out.println("Average rating for all movies in 2018: " + avgRating2018(ratings));    
        System.out.println("Hardest reviewer is #" + hardestReviewer2018(ratings));
        System.out.println("Worst movie is #" + worstMovie2018(ratings));
    }

    //Question 1
    public static int movieAvgRating(int[][] ratings, int movie) {
        int avg = 0;
        for (int r = 0; r < ratings.length; r++) {
            avg += ratings[r][movie];
        }
        return avg/ratings.length;
    }

    //Question 2
    public static int reviewerAvgRating(int[][] ratings,int reviewer) {
        int avg = 0;
        for (int c = 0; c < ratings[reviewer].length; c++) {
            avg += ratings[reviewer][c];
        }
        return avg/ratings[reviewer].length;
    }

    //Question 3
    public static int avgRating2018(int[][] ratings) {
        int avg = 0, count = 0;
        for (int r = 0; r < ratings.length; r++) {
            for (int c = 0; c < ratings[r].length; c++) {
                avg += ratings[r][c];
                count++;
            }
        }
        return avg/count;
    }

    //Question 4
    public static int hardestReviewer2018(int[][] ratings) {
        int avg1 = 0, avg2 = 0, avg3 = 0;
        for (int r = 0; r < ratings.length; r++) {
            for (int c = 0; c < ratings[r].length; c++) {
                if (r == 0) avg1 += ratings[r][c];
                if (r == 1) avg2 += ratings[r][c];
                if (r == 2) avg3 += ratings[r][c];
            }
        }
        avg1 = avg1/4;
        avg2 = avg2/4;
        avg3 = avg3/4;
        if (avg1 < avg2){
            if (avg1 < avg3) return 0;
        } else if (avg2 < avg3) {
            return 1;
        }
        return 2;
    }

    //question 5
    public static int worstMovie2018(int[][] ratings) {
        int avg1 = 0, avg2 = 0, avg3 = 0, avg4 = 0;
        for (int r = 0; r < ratings.length; r++) {
            for (int c = 0; c < ratings[r].length; c++) {
                if (c == 0) avg1 += ratings[r][c];
                if (c == 1) avg2 += ratings[r][c];
                if (c == 2) avg3 += ratings[r][c];
                if (c == 3) avg4 += ratings[r][c];
            }
        }
        avg1 = avg1/3;
        avg2 = avg2/3;
        avg3 = avg3/3;
        avg4 = avg4/3;
        if (avg1 < avg2 && avg1 < avg3 && avg1 < avg4) return 0;
        if (avg2 < avg1 && avg2 < avg3 && avg2 < avg4) return 1;
        if (avg3 < avg1 && avg3 < avg2 && avg3 < avg4) return 2;
        if (avg4 < avg1 && avg4 < avg2 && avg4 < avg3) return 3;
        return -1;
    }   
}