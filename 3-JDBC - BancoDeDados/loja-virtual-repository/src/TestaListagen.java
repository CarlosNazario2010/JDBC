import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagen {

	public static void main(String[] args) throws SQLException {
		
		CriaConexao novaCon = new CriaConexao();
		Connection con = novaCon.recuperaConexao();

		// cria o estado da conexao
		Statement stm = con.createStatement();
		
		// O m�todo devolve true quando o seu resultado � um java.sql.ResultSet 
		// e false caso contr�rio (update, delete, etc)
		boolean exe = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		System.out.println("Retorno � uma tabela do banco? " + exe);
		
		// itera sobre a tabela
		ResultSet rst = stm.getResultSet();
		while (rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id + " - " + nome + " - " + descricao);
		}
		
		con.close();
	}
}
