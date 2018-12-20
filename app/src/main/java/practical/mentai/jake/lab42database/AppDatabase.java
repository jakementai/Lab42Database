package practical.mentai.jake.lab42database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


//TODO 5: Create a database class

@Database(entities = {User.class}, version = 1) //User."TABLENAME" to connect to many other database
public abstract class AppDatabase extends RoomDatabase {

    //Create an instant of ROOM DATABASE
    private static volatile AppDatabase INSTANCE;

    //Create an instance of DAO
    public abstract UserDao userDao();

    static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){ //Db not created yet
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    //Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "user_db")
                    .build();
                }
            }
        }
        return INSTANCE;
    }

}
