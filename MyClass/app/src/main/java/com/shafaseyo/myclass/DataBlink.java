package com.shafaseyo.myclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DataBlink extends AppCompatActivity {

	String[] daftar;
	ListView ListView01;
	protected Cursor cursor;
	DataHelper dbcenter;
	public static DataBlink DBL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_blink);

		Button btn = findViewById(R.id.button2);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(DataBlink.this, InputData.class);
				startActivity(intent);
			}
		});

		DBL = this;
		dbcenter = new DataHelper(this);
		RefreshList();
	}

	public void RefreshList() {
		SQLiteDatabase db = dbcenter.getReadableDatabase();
		cursor = db.rawQuery("SELECT * FROM biodata", null);
		daftar = new String[cursor.getCount()];
		cursor.moveToFirst();
		for (int cc = 0; cc < cursor.getCount(); cc++) {
			cursor.moveToPosition(cc);
			daftar[cc] = cursor.getString(1).toString();
		}

		ListView01 = (ListView) findViewById(R.id.listView1);
		ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
		ListView01.setSelected(true);
		ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
				final String selection = daftar[arg2];
				final CharSequence[] dialogItem = {"Lihat Data", "Update Data", "Hapus Data"};
				AlertDialog.Builder builder = new
						AlertDialog.Builder(DataBlink.this);
				builder.setTitle("Pilihan");
				builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int item) {
						switch (item) {
							case 0:
								Intent detail = new Intent(getApplicationContext(), DetailData.class);
								detail.putExtra("nama", selection);
								startActivity(detail);
								break;
							case 1:
								Intent update = new Intent(getApplicationContext(), UpdateData.class);
								update.putExtra("nama", selection);
								startActivity(update);
								break;
							case 2:
								SQLiteDatabase db = dbcenter.getWritableDatabase();
								db.execSQL("delete from biodata where nama = '" + selection + "'");
								RefreshList();
								break;
						}
					}
				});
				builder.create().show();
			}
		});
		((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
	}
}