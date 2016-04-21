/**
 * 
 */
package com.example.weixinchatview;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * @author jy_dingsufu
 * 
 */
public class Weixin extends FragmentActivity {
	RadioGroup radioGroup;
	RadioButton main_tab_home, main_tab_daliy, main_tab_service, main_tab_my;
	List<Fragment> fragments;
	ViewPager indexViewPage;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		initView();

		initViewPager();

	}

	/**
	 * 初始化界面组件
	 */
	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		main_tab_home = (RadioButton) findViewById(R.id.radio0);
		main_tab_daliy = (RadioButton) findViewById(R.id.radio1);
		main_tab_service = (RadioButton) findViewById(R.id.radio2);
		main_tab_my = (RadioButton) findViewById(R.id.radio3);
		indexViewPage = (ViewPager) findViewById(R.id.viewPager);
		// RadioGroup选择事件
		radioGroup.setOnCheckedChangeListener(new MyCheckedListener());

	}

	/**
	 * 初始化ViewPager
	 */
	private void initViewPager() {

		fragments = new ArrayList<Fragment>();

		fragments.add(new Fragment_home());
		fragments.add(new Fragment_daliy());
		fragments.add(new Fragment_center());
		fragments.add(new Fragment_mine());
		FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),
				fragments);
		// 添加适配器
		indexViewPage.setAdapter(adapter);
		// ViewPager显示第一个Fragment
		indexViewPage.setCurrentItem(0);
		// ViewPager的页面选择改变事件
		indexViewPage.setOnPageChangeListener(new myPageChangeListener());

	}

	/**
	 * 页面滑动适配器
	 * 
	 * @author jy_dingsufu
	 * 
	 */
	class FragAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragments;

		public FragAdapter(FragmentManager fm) {
			super(fm);
		}

		public FragAdapter(FragmentManager fm, List<Fragment> fg) {
			super(fm);
			this.fragments = fg;
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

	}

	/**
	 * RadioButton切换Fragment
	 */
	class MyCheckedListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			switch (arg1) {
			case R.id.radio0:
				// ViewPager显示第一个Fragment且关闭页面切换动画效果
				indexViewPage.setCurrentItem(0, false);
				break;
			case R.id.radio1:
				indexViewPage.setCurrentItem(1, false);
				break;
			case R.id.radio2:
				indexViewPage.setCurrentItem(2, false);
				break;
			case R.id.radio3:
				indexViewPage.setCurrentItem(3, false);
				break;

			}

		}

	}

	/**
	 * ViewPager切换Fragment,RadioGroup做相应变化
	 */
	class myPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int state) {
			//

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			//

		}

		@Override
		public void onPageSelected(int arg0) {
			switch (arg0) {
			case 0:
				radioGroup.check(R.id.radio0);
				break;
			case 1:
				radioGroup.check(R.id.radio1);
				break;
			case 2:
				radioGroup.check(R.id.radio2);
				break;
			case 3:
				radioGroup.check(R.id.radio3);
				break;

			}

		}

	}

}
