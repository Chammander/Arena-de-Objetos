package dao;

public class DAOFactory {
    private static VitimaDAO vDAO = new VitimaDAO();

    public static VitimaDAO getVitimaDAO(){
        return vDAO;
    }//vitima

    private static GuerreiroDAO gDAO = new GuerreiroDAO();

    public static GuerreiroDAO getGuerreiroDAO(){
        return gDAO;
    }//guerreiro

    private static LadraoDAO lDAO = new LadraoDAO();
    
    public static LadraoDAO getLadraoDAO(){
       return lDAO;
    }//ladrao
}//fim class

