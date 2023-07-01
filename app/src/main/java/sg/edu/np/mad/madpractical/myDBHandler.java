package sg.edu.np.mad.madpractical;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDBHandler extends SQLiteOpenHelper {
    private final Context context;
    String title = "MyDBHandler";

    public static String DATABASE_NAME = "users.db";
    public static int DATABASE_VERSION = 1;
    public static String USER = "user";
    public static String COLUMN_NAME = "Name";
    public static String COLUMN_DESCRIPTION = "Description";
    public static String COLUMN_ID = "id";
    public static String COLUMN_FOLLOWED = "followed";

    public myDBHandler(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + USER + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + "TEXT, "
                    + COLUMN_DESCRIPTION + "TEXT, " + COLUMN_FOLLOWED + " INTEGER DEFAULT 0)";
            db.execSQL(CREATE_TABLE);
    }
    public void updateUser(User user){
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,user.getName());
        contentValues.put(COLUMN_DESCRIPTION,user.getDescription());
        contentValues.put(COLUMN_FOLLOWED,user.followed);
        sql.update(USER,contentValues,"_id=?", new String []{user.name});


    }
    public void addUser(User user) {
        SQLiteDatabase sql = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_DESCRIPTION, user.getDescription());
        contentValues.put(COLUMN_FOLLOWED, user.followed);
        sql.insert(USER, null, contentValues);
        sql.close();
    }
    public User findUser(User user){
        String QUERY = "SELECT * FROM " + USER + " WHERE " + COLUMN_NAME + "=\"" + user + "\"";
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(QUERY,null);
        boolean b = cursor.getInt(Integer.parseInt(COLUMN_FOLLOWED)) > 0;
        User queryResult = new User();

        if(cursor.moveToFirst()){
            queryResult.setId(cursor.getInt(0));
            queryResult.setName(cursor.getString(1));
            queryResult.setDescription((cursor.getString(2)));
            queryResult.setFollowed((b));
        }else{
            queryResult = null;
        }
        return queryResult;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER);
        onCreate(db);
    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);

        }
        return cursor;
    }
}
