package DATA;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ArthurF on 24/07/16.
 */
/*public class MoradorDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TCC_SI_M_12.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String OPEN_PAR = "(";
    public static final String CLOSE_PAR = ")";
    public static final String SQL_CREATE_MORADOR =
            "CREATE TABLE " + MoradorContract.MoradorEntry.TABLE_NAME + OPEN_PAR +
                    MoradorContract.MoradorEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    MoradorContract.MoradorEntry.COLUMN_NAME_NOME_COMPLETO + TEXT_TYPE + CLOSE_PAR;
    public static final String SQL_DROP_COR =
            "DROP TABLE IF EXISTS " + CategoriasContract.CorEntry.TABLE_NAME;
    public static final String SQL_CREATE_ESTILO =
            "CREATE TABLE " + CategoriasContract.EstiloEntry.TABLE_NAME + OPEN_PAR +
                    CategoriasContract.EstiloEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CategoriasContract.EstiloEntry.COLUMN_NAME_ESTILO_NOME + TEXT_TYPE + CLOSE_PAR;
    public static final String SQL_DROP_ESTILO =
            "DROP TABLE IF EXISTS " + CategoriasContract.EstiloEntry.TABLE_NAME;
    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE " + CategoriasContract.PaisEntry.TABLE_NAME + OPEN_PAR +
                    CategoriasContract.PaisEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CategoriasContract.PaisEntry.COLUMN_NAME_PAIS_NOME + TEXT_TYPE + CLOSE_PAR;
    public static final String SQL_DROP_PAIS=
            "DROP TABLE IF EXISTS " + CategoriasContract.PaisEntry.TABLE_NAME;


    public MoradorDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_COR);
        db.execSQL(SQL_CREATE_ESTILO);
        db.execSQL(SQL_CREATE_PAIS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //tabelas de parâmetros que podem ser recriadas
        db.execSQL(SQL_DROP_COR);
        db.execSQL(SQL_DROP_ESTILO);
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_CREATE_COR);
        db.execSQL(SQL_CREATE_ESTILO);
        db.execSQL(SQL_CREATE_PAIS);
    }

}*/
