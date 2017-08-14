package raj.salam.com.myadda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener {

    SliderLayout mSliderLayout;
    HashMap<String,Integer> files;
    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = new TabHost(this);
        mTabHost = (TabHost)findViewById(R.id.tbhost);
        mTabHost.setup();

        mTabHost.addTab(mTabHost.newTabSpec("POST").setIndicator("POST").setContent(new Intent(this,Posts.class)));
        mTabHost.addTab(mTabHost.newTabSpec("Complaints").setIndicator("COMPLAINTS").setContent(new Intent(this,Complaints.class)));
        mTabHost.addTab(mTabHost.newTabSpec("Other").setIndicator("Your Post/Complaint\nStatus").setContent(new Intent(this,Status.class)));
        mTabHost.setCurrentTab(0);
        mSliderLayout = (SliderLayout)findViewById(R.id.slider);

        files = new HashMap<String, Integer>();
        files.put("Hannibal",R.drawable.hannibal);
        files.put("Big Bang Theroy",R.drawable.bigbang);
        files.put("House of cards",R.drawable.house);
        files.put("Game of Thrones",R.drawable.game_of_thrones);


        for (String name:files.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(files.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("Extra",name);

            mSliderLayout.addSlider(textSliderView);

        }

        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);
        mSliderLayout.addOnPageChangeListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
