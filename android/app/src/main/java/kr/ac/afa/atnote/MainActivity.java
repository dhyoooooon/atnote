package kr.ac.afa.atnote;

import android.app.Fragment;
import android.os.Bundle;
        import android.support.design.widget.NavigationView;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v7.app.ActionBarDrawerToggle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.view.View;
import kr.ac.afa.atnote.TTMapsActivity;

/**
 * 지점 정보앱의 핵심 액티비티이며 왼쪽에 네비게이션 뷰를 가지며
 * 다양한 프래그먼트를 보여주는 컨테이너 역할을 한다.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = getClass().getSimpleName();

    DrawerLayout drawer;
    View headerLayout;

    /**
     * 액티비티와 네비게이션 뷰를 설정하고 BestFoodListFragment를 화면에 보여준다.
     * @param savedInstanceState 액티비티가 새로 생성되었을 경우, 이전 상태 값을 가지는 객체
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        headerLayout = navigationView.getHeaderView(0);

    }


    /**
     * 폰에서 뒤로가기 버튼을 클릭했을 때 호출하는 메소드이며
     * 네비게이션 메뉴가 보여진 상태일 경우, 네비d게이션 메뉴를 닫는다.
     */
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 네비게이션 메뉴를 클릭했을 때 호출되는 메소드
     * @param item 메뉴 아이템 객체
     * @return 메뉴 클릭 이벤트의 처리 여부
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        android.app.FragmentManager manager = getFragmentManager();

        if (id == R.id.nav_list) {
            manager.beginTransaction().replace(R.id.content_main, new MainActivity1()).commit();
        } else if (id == R.id.nav_map) {
            manager.beginTransaction().replace(R.id.content_main, new MainActivity2()).commit();
        } else if (id == R.id.nav_keep) {
            manager.beginTransaction().replace(R.id.content_main, new MainActivity3()).commit();
        } else if (id == R.id.nav_register) {
            manager.beginTransaction().replace(R.id.content_main, new MainActivity4()).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}