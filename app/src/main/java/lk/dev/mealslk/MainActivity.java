    package lk.dev.mealslk;

    import android.os.Bundle;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;

    import lk.dev.mealslk.adapters.ItemSquareAdapter;
    import lk.dev.mealslk.models.ItemSquareModel;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ItemSquareModel> favoriteItems = new ArrayList<>();
        ItemSquareAdapter favoritesAdapter = new ItemSquareAdapter(this, favoriteItems);
        RecyclerView favoritesRecyclerView = findViewById(R.id.favorites_recycler_view);

        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        favoritesRecyclerView.setAdapter(favoritesAdapter);
        for (int i = 0; i < 10; i++) {
            favoriteItems.add(new ItemSquareModel(R.drawable.common_google_signin_btn_icon_dark_normal_background, "Title " + i));
            favoritesAdapter.notifyDataSetChanged();
        }

        ArrayList<ItemSquareModel> nearbyItems = new ArrayList<>();
        ItemSquareAdapter nearbyAdapter = new ItemSquareAdapter(this, nearbyItems);
        RecyclerView nearbyRecyclerView = findViewById(R.id.nearby_recycler_view);

        nearbyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        nearbyRecyclerView.setAdapter(nearbyAdapter);
        for (int i = 0; i < 10; i++) {
            nearbyItems.add(new ItemSquareModel(R.drawable.common_google_signin_btn_icon_dark_normal_background, "Title " + i));
            nearbyAdapter.notifyDataSetChanged();
        }

    }
}
