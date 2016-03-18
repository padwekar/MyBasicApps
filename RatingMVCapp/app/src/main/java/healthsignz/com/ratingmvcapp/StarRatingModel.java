package healthsignz.com.ratingmvcapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devuser on 17-03-2016.
 */
public final class StarRatingModel {
    private int stars = 1;
    private List<Listener> listenersList = new ArrayList<Listener>();
    public static final int MAX_STARS = 5;

    public  interface Listener {
        void handleStarRatingChange(StarRatingModel sender);
        }

    public StarRatingModel(){
    }

    public int getStars(){
        return stars;
    }

    public void setStar(int stars) {
        if (stars > MAX_STARS)
            stars = MAX_STARS;
        if (stars < 0)
            stars = 0;
        if (stars != this.stars) {
            this.stars = stars;

            for(Listener listener : listenersList)
                listener.handleStarRatingChange(this);

        }
    }
    public void addListener(Listener listener){
        this.listenersList.add(listener);
    }

    public void removeListener(Listener listener){
        this.listenersList.remove(listener);
    }



}
