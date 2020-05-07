import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler extends Configs {
    Connection con;

    public Connection getCon()
            throws ClassNotFoundException, SQLException {
        String ConString = "jdbc:postgresql://localhost:3306/my_base";
        Class.forName("org.postgresql.jdbc.Driver");
        con = DriverManager.getConnection(ConString, dbUser, dbPass);
        return con;
    }
    public void Del(String table, int id){
        PreparedStatement del = null;
        try {
            del = getCon().prepareStatement("delete from " + table + " where (id" + table +") = ?");
            del.setInt(1, id);
            del.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Edit(String table,String colum, String id, int id_v, String value){
        int value_ = 0;
        if (colum == "idshop"){value_ = Integer.parseInt(value);
        }
        PreparedStatement upd = null;
        try {
            String str = "UPDATE " + table + " SET "+ colum +" = ? WHERE " + id + " = ?";
            upd = getCon().prepareStatement(str);
            upd.setInt(2, id_v);
            if (colum == "idshop")upd.setInt(1, value_);
            else upd.setString(1, value);
            upd.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddEmployee(String name, String posit, int id, String age, String salary, int id_p) {
        String sql = "INSERT INTO `my_base`.`employee` (`idshop`, `full_name`, `position`, `age`, `salary`, " +
                "`idposition`) VALUES ('6', 'Luiza', 'admin', '34', '9000', '1')";
        String insert = "INSERT INTO employee(idshop, full_name, position, age, salary, idposition) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getCon().prepareStatement(insert);
            prSt.setString(2, name);
            prSt.setString(3, posit);
            prSt.setInt(1, id);
            prSt.setString(4, age);
            prSt.setString(5, salary);
            prSt.setInt(6, id_p);

            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void AddReportSh(String profit, String expenses, int id, String date) {
        String insert = "INSERT INTO report_shop(idshop, profit, expenses, date) VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getCon().prepareStatement(insert);
            prSt.setString(2, profit);
            prSt.setString(3, expenses);
            prSt.setInt(1, id);
            prSt.setString(4, date);
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddShop(String address, String email) {
        String insert = "insert into shop (address, email) values(?,?)";

        try {
            PreparedStatement prSt = getCon().prepareStatement(insert);
            prSt.setString(1, address);
            prSt.setString(2, email);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void AddPosit(String position_) {
        String insert = "insert into position (position) values(?)";

        try {
            PreparedStatement prSt = getCon().prepareStatement(insert);
            prSt.setString(1, position_);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddProduct(String product_, int idsh) {
        String insert = "insert into product (product, idshop) values(?, ?)";

        try {
            PreparedStatement prSt = getCon().prepareStatement(insert);
            prSt.setString(1, product_);
            prSt.setInt(2, idsh);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<Empl_addr> SortEmp(String address_) {
        ObservableList<Empl_addr> EmployeeData = FXCollections.observableArrayList();


        String SQL = "select employee.full_name, employee.position, shop.address from employee " +

                "join shop on employee.idshop = shop.idshop where shop.address='" + address_ + "'";

        PreparedStatement res = null;
        try {
            res = getCon().prepareStatement(SQL);

            ResultSet rs = res.executeQuery();

            while (rs.next()) {
                EmployeeData.add(new Empl_addr(rs.getString(1), rs.getString(2),
                        rs.getString(3)));
            }
//
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return EmployeeData;
    }

    public ObservableList<Product> SortProd(int id) {
        ObservableList<Product> ProdDat = FXCollections.observableArrayList();

        String SQL = "select product.idproduct, product.product, product.idshop from product " +

                "join shop on product.idshop = shop.idshop where shop.idshop='" + id + "'";

        PreparedStatement res = null;
        try {
            res = getCon().prepareStatement(SQL);
            ResultSet rs = res.executeQuery();
            while (rs.next()) {
                ProdDat.add(new Product(rs.getInt(1), rs.getInt(3),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ProdDat;
    }

    public int SortReport(int id) {

        String SQL = "select sum(report_shop.profit) - sum(report_shop.expenses) from report_shop " +

                "join employee on employee.idshop = report_shop.idshop where employee.idemployee='" + id + "'";
        int sum = 0;
        PreparedStatement res = null;
        try {
            res = getCon().prepareStatement(SQL);
            ResultSet rs = res.executeQuery();

            while (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sum;
    }

    public ObservableList<Employee> SortEmpPos(int id) {
        ObservableList<Employee> EmDat = FXCollections.observableArrayList();

        String SQL = "select * from employee " +

                "join position on employee.idposition = position.idposition where position.idposition='" + id + "'";

        PreparedStatement res = null;
        try {
            res = getCon().prepareStatement(SQL);
            ResultSet rs = res.executeQuery();
            while (rs.next()) {
                EmDat.add(new Employee(rs.getInt(1), rs.getString(3),
                        rs.getString(4), rs.getInt(2), rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return EmDat;
    }


    public ObservableList<Employee> ShowEmployee() {
        ObservableList<Employee> EmployeeData = FXCollections.observableArrayList();

        try {
            PreparedStatement res = getCon().prepareStatement("select * from employee");
            ResultSet rs = res.executeQuery();
            while (rs.next()) {
                EmployeeData.add(new Employee(rs.getInt(1), rs.getString(3),
                        rs.getString(4), rs.getInt(2), rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return EmployeeData;
    }
    public ObservableList<Position> ShowPosition() {
        ObservableList<Position> PositionData = FXCollections.observableArrayList();

        try {
            PreparedStatement res = getCon().prepareStatement("select * from position");
            ResultSet rs = res.executeQuery();
            while (rs.next()) {
                PositionData.add(new Position(rs.getInt(1), rs.getString(2)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return PositionData;
    }

    public ObservableList<ReportShop> ShowReportSh() {
        ObservableList<ReportShop> EmployeeReportS = FXCollections.observableArrayList();

        try {
            PreparedStatement res = getCon().prepareStatement("select * from report_shop");
            ResultSet rs = res.executeQuery();
            while (rs.next()) {
                EmployeeReportS.add(new ReportShop(rs.getInt(2), rs.getInt(1),
                        rs.getString(3), rs.getString(4),  rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return EmployeeReportS;
    }

    public ObservableList<Shop> ShowShop() {
        ObservableList<Shop> ShopData = FXCollections.observableArrayList();

        try {
            PreparedStatement prs = getCon().prepareStatement("select * from shop");
            ResultSet res = prs.executeQuery();
            while (res.next()) {
                ShopData.add(new Shop(res.getInt(1), res.getString(2),
                        res.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ShopData;
    }

    public ObservableList<Product> ShowProduct() {
        ObservableList<Product> ProductData = FXCollections.observableArrayList();

        try {
            PreparedStatement prs = getCon().prepareStatement("select * from product");
            ResultSet res = prs.executeQuery();
            while (res.next()) {
                ProductData.add(new Product(res.getInt(1), res.getInt(3), res.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ProductData;
    }
}
