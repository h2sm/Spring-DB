package database;
import javax.sql.DataSource;

public class DBService implements DBInterface {
    private final DataSource src;
    private final DBRepository repository;

    public DBService(DataSource ds, DBRepository dbr) {
        this.src = ds;
        this.repository = dbr;
    }


    @Override
    public void findAll() {

    }

    @Override
    public void find(String str) {

    }
}
