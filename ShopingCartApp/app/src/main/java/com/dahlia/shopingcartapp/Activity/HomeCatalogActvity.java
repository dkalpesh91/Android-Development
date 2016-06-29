package com.dahlia.shopingcartapp.Activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.dahlia.shopingcartapp.Adapter.CustomPagerAdapter;
import com.dahlia.shopingcartapp.Adapter.MyCustomAdapter;
import com.dahlia.shopingcartapp.Constant.ConstantUrl;
import com.dahlia.shopingcartapp.ControllerHelper.AppController;
import com.dahlia.shopingcartapp.Model.ProductCatalog;
import com.dahlia.shopingcartapp.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class HomeCatalogActvity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	List<ProductCatalog> mProductList = null;
	ProgressDialog mDialog = null;
	MyCustomAdapter mAdapter = null;
	ListView mListView = null;

	ViewPager mViewPager = null;

	private String url = ConstantUrl.HOST_URL + ConstantUrl.FETCH_PRODUCT_CATALOG_SUB_URL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_catalog);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(), "Profile creation page", Toast.LENGTH_SHORT).show();
			}
		});

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
				R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		mProductList = new ArrayList<ProductCatalog>();

		final String[] productList = { "MobilePhone", "MobileAcces", "Tablet", "Laptop", "Computer", "MobilePhone",
				"MobileAcces", "Tablet", "Laptop", "Computer" };
		ListView listView = (ListView) findViewById(R.id.listView);
		mAdapter = new MyCustomAdapter(this, mProductList);
		listView.setAdapter(mAdapter);

		final ViewPager viewPager1 = (ViewPager) findViewById(R.id.viewpager1);
		final CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this, mProductList);
		viewPager1.setAdapter(customPagerAdapter);

		mDialog = new ProgressDialog(this);
		// Showing progress dialog before making http request
		mDialog.setMessage("Loading...");
		mDialog.show();

		JsonArrayRequest productFetchRequest = new JsonArrayRequest(
				ConstantUrl.HOST_URL + ConstantUrl.FETCH_PRODUCT_CATALOG_SUB_URL, new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.d("Response:", response.toString());
						hidePDialog();

						// Parsing json
						for (int i = 0; i < response.length(); i++) {
							try {

								JSONObject obj = response.getJSONObject(i);
								ProductCatalog product = new ProductCatalog();
								product.setProductName(obj.getString("ProductName"));
								product.setProductImageUrl(ConstantUrl.HOST_URL + "/" + obj.getString("ProductImage"));
								product.setProductDetails(obj.getString("Description"));
								product.setProductCategory(obj.getInt("CategoryId"));
								product.setProductCost(obj.getInt("ProductPrice"));
								// movie.setRating(((Number) obj.get("rating"))
								// .doubleValue());
								// movie.setYear(obj.getInt("releaseYear"));
								//
								// // Genre is json array
								// JSONArray genreArry =
								// obj.getJSONArray("genre");
								// ArrayList<String> genre = new
								// ArrayList<String>();
								// for (int j = 0; j < genreArry.length(); j++)
								// {
								// genre.add((String) genreArry.get(j));
								// }
								// movie.setGenre(genre);

								// adding movie to movies array
								mProductList.add(product);

							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						mAdapter.notifyDataSetChanged();
						customPagerAdapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						VolleyLog.d("Volley", "Error: " + error.getMessage());
						hidePDialog();

					}
				});

		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(productFetchRequest);

		Button showNotification = (Button) findViewById(R.id.showNotificationBtn);

		// new JSONAsyncTask().execute(url);

	}

	void showNotification(View view) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setAutoCancel(true);
		builder.setContentTitle("Simple");
		builder.setContentText("This is simple context");
		builder.setSmallIcon(R.drawable.ic_menu_camera);

		Notification notification = builder.build();
		NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(8, notification);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		hidePDialog();
	}

	private void hidePDialog() {
		if (mDialog != null) {
			mDialog.dismiss();
			mDialog = null;
		}
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_catalog_actvity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
//		if (id == R.id.action_settings) {
//			return true;
//		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			// Handle the camera action

		} else if (id == R.id.nav_gallery) {

			Intent i =new Intent(this,ProductDescriptionActivity.class);
			startActivity(i);


		} else if (id == R.id.nav_slideshow) {
			Intent i =new Intent(this,ProductDescriptionActivity.class);
			startActivity(i);

		} else if (id == R.id.nav_manage) {
			Intent i =new Intent(this,ProductDescriptionActivity.class);
			startActivity(i);

		} else if (id == R.id.nav_share) {
			Intent i =new Intent(this,ProductDescriptionActivity.class);
			startActivity(i);

		} else if (id == R.id.nav_send) {
			Intent i =new Intent(this,ProductDescriptionActivity.class);
			startActivity(i);

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

}
