package test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;
import model.*;
import dao.*;

public class Test {
	
		
		public static String saisieString(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			return monScanner.nextLine();
			//return var;
		}
		public static int saisieInt(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			int var = monScanner.nextInt();
			return var;
		}
		public static double saisieDouble(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			double var = monScanner.nextDouble();
			return var;
		}
		public static boolean saisieBoolean(String msg) 

		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			boolean var = monScanner.nextBoolean();
			return var;
		}

		static Tapoteur connected;
		static IDAOCulte daoC = Singleton.getInstance().getDaoCulte();
		static IDAODemande daoD = Singleton.getInstance().getDaoDemande();
		static IDAOActivite daoA = Singleton.getInstance().getDaoActivite();
		static IDAOFidele daoF = Singleton.getInstance().getDaoFidele();
		static IDAOTapoteur daoT = Singleton.getInstance().getDaoTapoteur();
		
		
		public static void mainMenu()
		{
			
			System.out.println("cccccccccccccclllllllllllllllllllllllllllloooooooooollc:ccllc:,..     ................',;clloooooooooooooooooooooooooddoddoooddooddddddooooooooooooooooooooooooooooooooooooooooooooooooooollllllllllllll\r\n"
					+ "cccccccccccclllllllllllllllllllllllllllllllloooollllclllcc;'..         ...    ...........',;ccllooooooooooooooooooooooooodoooddddddddddddooooooooooooooooooooooooooooooooooooooooooooooooooollllllllllll\r\n"
					+ "ccccccccccllllllllllllllllllllllllllllllllollllllccclc:,...      ............................',;:ccclllooooooooooooooooooooddddddddddddddddddddddddooooooooooooooooooooooooooooooooooooooooooooollllllll\r\n"
					+ "cccccccccllllllllllllllllllllllllllllllllloolllcccc:;,.......   ....................  ......  ...'',,;;:ccloooooooooooooooddddddddddddddddddddddddddddddddddoooooooooooooooooooooooooooooooooooooollllll\r\n"
					+ "cccccccccllllllllllllllllllllllllllloooooooollccc:;,'........  ...    ......  ...........   .   .......''',;::ccclloooooooddddddddddddddddddddddddddddddddddddddoooooooooooooooooooooooooooooooooooollll\r\n"
					+ "ccclllllllllllllllllllllllllllllllloooooooollc:;,,'..........    ...    ................    ..  ..............';;;;:llloooddodddddddddddddddddddddddddddddddddddddddoooooooooooooooooooooooooooooooooooo\r\n"
					+ "ccccllllllllllllllllllllllllllllllooooooooll:;,''....  ..   .. ...........    .........    .....................'''',:clooooodddddddddddddddddddddddddddddddddddddddddoooooooooooooooooooooooooooooooooo\r\n"
					+ "cccllllllllllllllllllllllloooooooooooooollc;,'......            ..........     ......................................';clllcloddddddddddddddddddddddddddddddddddddddddddoooooooooooooooooooooooooooooooo\r\n"
					+ "llllllllllllllllllllllllooooooooooooolcc:;'...                  ...            ........................................;:clccloddddddddddddddddddddddddddddddddddddddddddddddddddooooooooooooooooooooooo\r\n"
					+ "llllllllllllllllllllllllooooooooooollc;'.....                      .             ............... ......................';:cc::looddddddddddddddddddddddddddddddddddddddddddddddddddooooooooooooooooooooo\r\n"
					+ "llllllllllllllllllooooooooooooooool:,..  ....       ....                         ...............     ............     ..,;:;,,,;cldddddddddddddddddddddddddddddddddddddddddddddddddddooooooooooooooooooo\r\n"
					+ "lllllllllllllllloooooooooooooooooc,..               ...                          .................................     ..,,.....,codddddddddddddddddddddddddddddddddddddddddddddddddddddoooooooooooooooo\r\n"
					+ "llllllllllllllloooooooooooooooooc,........          ..       .   ... .    ..    .............',,,,,,'''..........       ....   ..':lodddddddddddddddddddddddddddddddddddddddddddddddddddddoooooooooooooo\r\n"
					+ "lllllllllooooooooooooooooooooool,........          ...       ..  ......   ..............''',;::ccccccc::;,'.......               ..;lodddddxxxxdddxxdddxxxddddddddddddddddddddddddddddddddddddddoooooooo\r\n"
					+ "llllllllooooooooooooooooooooool,....           ........       ..  .................'',,;;::clloooooooolllc:,'.....                ..;loddddxxxddddxxdddxxxdddddddddddddddddddddddddddddddddddddddooooooo\r\n"
					+ "lllllllooooooooooooooooooooooo:.....              ........     .  ..........'',,;;::cccllloooddddddooooooolc:;,'..                  .;lddddxxxxxxxxxxdxxxxxxxxdddddddddddddddddddddddddddddddddddddooooo\r\n"
					+ "lllloooooooooooooooooooooooool,....                  .....     ..........'',;;::cclllooooooodddddddddddddoooolc:,'...               .':odddxxxxxxxxxxxxxxxxxxxxddxxddddddddddddddddddddddddddddddddddddd\r\n"
					+ "oooooooooooooooooooooooooooodo;..                        .............'',;;::ccllloooooddodddddddddddddddddddooll:,...               .':odxddxxxxxxxxxxxxxxxxxxxxxxxxxdddddddddddddddddddddddddddddddddd\r\n"
					+ "ooooooooooooooooooooooooooodooc.                         ..........',;;:::cclllooooooodddddddddddddddddddddddddoooc:,..              ..:oddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddddddddddddddddddddddddddd\r\n"
					+ "oooooooooooooooooooooooooooool,.                       .......'',,;::ccclllloooooooodddddddddddddddddddddddddddddoooc:,..             ..;codxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddddddddddddddddddddddddd\r\n"
					+ "ooooooooooooooooooooooooooooc'. ..                    ....',,;;:::ccclllloooooooooodddddddddddddddddddddddddddddddoolc,......           .':odxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddddddddddddddddd\r\n"
					+ "ooooooooooooooooooooooddoool,...                  .....'',;;::cccccclllooooooooooooddddddddddddddddddddddddddddddddol:,..........        .'cdxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddddddddddddddd\r\n"
					+ "oooooooooooooooooodoooooool;...                 .....',;;::ccccclllllllooooodddooddddddddddxxxxxxxxdddddddddddddddddol:,''.......         .;oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddddddddddddd\r\n"
					+ "ooooooooooooooooodoooooool:'..               ......',;:::ccclllllllllloooooddddddddddddddddxxxxxxxxxxxxdxxdddddddddddolc:,'......          .:dxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddddddd\r\n"
					+ "ooooooooooooooooddddddddol:,.....           ..'',,;::::ccccllllllllooooooooddddddddddddddddxxxxxxxxxxxxxxxxxxxxxxxxddddol:,'.....          .'cddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddddddd\r\n"
					+ "ooooooooooooooddddddddddoc:,. ...          .',;;;::::ccccllllllllloooooooooodddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddol;'......          .,codxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddddd\r\n"
					+ "ooooooooodddddddddddddddoc;'....          .',;;::::cccclllllllllllloooooooooddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddoc;''...          ...'codxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddd\r\n"
					+ "ooooooooddddddddddddddddoc;'....         ..,:::::ccccccllllllllllloooooooooddddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddddoc,'.......        ..,coxxxxxkkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddd\r\n"
					+ "oooooooodddddddddddddddddl;.....        ..,;::::cccccccllllllllllloooooooodddddddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddo:,'.....         ...;ldxxkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n"
					+ "oooddddddddddddddddddddddl;'....        ..,;:::ccccccccllllllllllllooooooooddddddddddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddoc,...........   ...;ldxkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n"
					+ "oodddddddddddddddddddddddoc;...         ..,::ccccccccccllllllllllloooooooodddddddddddddxxxxxxxxxxkkxxxxxxxxxxxxxxxxxxxxxxxxddoc,.... ....   ...'cdxkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxxxxxxxxxxx\r\n"
					+ "oddddddddddddddddddddddddolc,.         ..';::ccccccccllllllllllllooooooooddddddddddddxxxxxxxxxxxkkkkxxxxxxxxxxxxxxxxxxxxxxxxxxdc'....      ....;oxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxxxxxx\r\n"
					+ "ddddddddddddddddddddddddddol;..        ..',::cccccccclllllllllooooooooddddddddddddddxxddxxxxxxxxkkkxxxxxxxddoooooddddxxxxxxxxxxdc'...     .....,lxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxx\r\n"
					+ "dddddddddddddddddddddddddddo:..         ..,;:ccccccllllllllloooooooooddddddddddddddddxxxxxxxxxxxxxxddddolc:::;;;;:::clodxxxxxxxxdl;..      ....'cdxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxxxxx\r\n"
					+ "dddddddddddddddddddddddddddoc,.         ..,;:ccccccllllllloooooooooodddddddddddddddddxxxdddddddolc::;;;,''...'''''',,;:coddxxxxxxdl;..      ..,:odddxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxxxxxx\r\n"
					+ "dddddddddddddddddddddddddxddl;.         ..';:ccccclllllllooooooooooooddddddddddddddddddddooolc;'............',;;:::ccccccodxxxxxxxdc'...   ..,codoccdkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxxxx\r\n"
					+ "dddddddddddddddddddxxxxxddddo;.         ...,:cccccclllllllooooooooooooooooddddooodddddddolc:;,...........'',;;:;::ccloolllodxxxxxxxo;.......':oddl::lxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxxxx\r\n"
					+ "ddddddddddddddddxxxxxxxxxxxxd:..         ..,;:cccccclllllllllllccccccccccllooooooodddddoolc:;;;,,'......'',,,;;::::::cloddddxxxxxxxdc,.....,:ldddolcldkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxx\r\n"
					+ "ddddddddddddddxxxxxxxxxxxxxxxo,..         .';:ccccccccc:;;;;,''.....'',,;:ccllloooodddddooollcc:,'..''.....''';cc:;:cclodxxxxxxkkxxxo:....':loxxxdlcldkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxx\r\n"
					+ "dddddddddddddxxxxxxxxxxxxxxxxxo:'.        ..;:cccccc;,'........ ........',,;:cllloodxxxxxdddolc:,',,,;,....';,:oxoc:cloddxxxkkkkkkkxxl,...,coxkkxdollxkOOkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxkkk\r\n"
					+ "ddddddxxxxxxxxxxxxxxxxxxxxxxxxxdl,.       ..;:cccc;'.....................'',;:clloddxkkkkxxdolc:;;;:clc,.....,:dxdoooddxxxxkkkkkkkkkkxc,..;ldxkkkxoloxkOOOOOOOkkOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "dddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxo:.       .,:ccc;'.....'','''.......  ....',,:clodxxkkkkxxddddol::ccllc:,'';codddoddxxxxkkkkkkkkkkkkkd:'':loodxkxddxkOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "dddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdl,.      .,:cc:,'.',,;;;,''................',:clodxkkkkxxxxxxxdlccccccllccloooddddxxkkkkkkkkkkkkkkkkxl,':lolodxkxxkkOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "dddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxo;.      .':cc:,',;;:;;''.''.......','.....',,:cldxxkkkkkxxxkxxolcc:::::cclloddxxxkkkkkkkkkkkkkkkkkkkd:,cdxdoodxkkkOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "dddxxxxxxxxxxxxxxxxxxxxxxxxxxkkxxxo:..      .;cc:;;;::;,'..'::,....''':c;'..',,;;clodxkkkkkkxxkxxddooollllooddxxxxkkkkkkkkkkkkkkkkkkkkkxc;:dkkxdoxkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxxxxxxxxxxxxkkkkxxxdl,..     .,ccc:::::;'..';ll:'.....;lo:;,,,;;;;:coddxkkkkkkkkkkxxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkxl;:okkkdoxkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxxxxxxxxkkxkkkkkkkxdo;...     .:cccccc:;''',;cllc;'',;clc:;;,,,;;::clodxkkkkkkkkkkkkkkkkkkkkkxxkkkkkkkkkkkOOOOOOOOkkkkkkxl;;okkxddxkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxxxxxxxxkkkkkkkkkkxxxl;...    .;clllcc:;;;;;;::ccc:::::;;;;;;;;:::cclodxkkkkkkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOkkkkxo;,lxxddxkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkxl,....  .'cllllcc:::::::::;;;;;;;:::::::cccccclodxkkkkkkkkkkOOOOOOOOkOOkkkkkkOOOOOOOOOOOOOOOOOOOkkxo;,:dxxkOkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkxl,.... ..:llllllcccccc::::::cccccllllcclccccclodxkkkkkkkkkOOOOOOOOOkOkkkkkkkkOOOOOOOOOOOOOOOOOOkkxo;';dkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkxc'......;llllllllllllllllllllllllllllllllccclodxkkOOOOOkkOOOOOOOOOOOkkkkkkkkkOOOOOOOOOOOOOOOkOkkxl;',okOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkOkkkkkkkk\r\n"
					+ "xxxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkdc'.....'clllllllllllooooooooooollllllllllcllodxkkOOOOOOOOkkOOOOOkkkkkkkkkkkkOOOOOOOOOOOOOOOOkkkxo:,,ckOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkOOOkkkkkk\r\n"
					+ "xxxxxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkko;'.....;lllloolooooooooooooooooooollllllllooxxkOOOOOOOOOkkkkkkkxkkkkkkkkkkkOOOOOOOOOOOOOOOkkkkxo:,':dkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkkk\r\n"
					+ "xxxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkko:,','.':lllllooooooooodddddoooooollllllllodxxkkOOOOOOOOOkkkkkxxxxxxxxxkkkkkkkkkOOOOOOOOOkkkkkxo:,':dxkkOOO00OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkkk\r\n"
					+ "xxxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxoc:;'.'clllloollooodddddddoooooolllcccclodxxkkOOOOOOOOOOOOOOkkxxxxxxxxxkkkkkkOOOOOOOOkkkkkkxxo:'';dOOO00000OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkkk\r\n"
					+ "xxxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkOOkkkdc,..,clllllloooooddddddoooooollc:::cloddxxkkOOOOOOOOOOOOOOkkkkkkxxxxxxxkkkkkOOOOOOkkkkkkxdl;'.;dO00000000OOO0000000000OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkk\r\n"
					+ "xxxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkOkkkOkkkOkd:,..,:lllllooooodddddddooooolc:::clooodddxkkkOOkkxdoooodkkkkkOkkkkxxxxkkkkkkkOOkkkkkkkkxoc;'.,oO00000000000000000000000OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOko:,'.,:llloooooodddddddddoollc::clolllloodxxkkkxdlcccccodkkkOOOOkkkkkkkkkkkkkOkkkkkkkxxdl:,'.,oO00000000000000000000000000OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxxxxkkkkkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOxl:;'.,:llloooooooddddddooollcc:clc:;;;cloddxxxxxddddddxkkkkOOOOOkkkkkkkkkkkkkkkkkkkkxdoc;,'';okO0000000000000000000000000000OOOOOOOOOOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxxxxkkkkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOkdlc:,.,cllloooooooodddoooolcccccc:;,,,;:clloodxxxxxkkkkkkkkkOOOOkkkkkkkkkkkkkkkkkkkxxdl:,,'';lkO000000000000000000000000000000OOOOOOOOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxxxxkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOkoll:,.,clllloooooooooooollllccccc::;;;;;::clooooodxxdxxxxkkkkkkxxddddxxkkkkOkkkkkxdolc;,,,,;lkO000000000000000000000000000000000OOOOOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxkkkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOxolc;..,cllllooooooooooolllllllccc::;;;;;:clllcccloooloodxxxxxddoollloxxxkkkkkkkxdoc::;,,,;cxO0000000000000000000000000000000000000OOOOOOOOOOOOOOOOOOOO\r\n"
					+ "xxxkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOxolc;,..,:lllllloooooooolllllllcccc:;,,,;;::cc;,;clllcloodxdxxdooddddxxxxkkkkkkxdoc:;;;,,;cdO00000000000000000000000000000000000000000O00OOOOOOOOOOOOOO\r\n"
					+ "xxxkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOkdocc;,..':clllllllllllllllccccccc::;,,,;;;;:::;:coooodddddoolccldxxkkkxxkkkkkxdoc:;,,,',,lxO000000000000000000000000000000000000000000000OOOOOOOOOOOOO\r\n"
					+ "xxxkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOkxxddo;..,:cllllllllllllcc::::::;;,,,;;::cllloooooooollllccccldkOOOOkkkkkkkxdlc:;,,,''',lkO00000000000000000000000000000000000000000000OOOOOOOOOOOOOO\r\n"
					+ "kkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOx:..';ccllllllllc:;,,,,;;;;;;;;::cccllllllccccccloooddxkOOOOOOOOkkkkxxoc:;;,,''',,:okO00000000000000000000000000000000000000000000OOOOOOOOOOOOO\r\n"
					+ "kkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOx:...,:cclllllc:,'..'',;:c::::;;;;;;;::::ccclodxxxxxkkOOOOOOOOOOOkxdooc:;;,'..,;;;:ldO0K00000000000000000000000000000000000000000OOOOOOOOOOOOO\r\n"
					+ "xxkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO00Ox:...',:cclllc:;,'',;;:;,,'''''',;;:cllllllodxxxxkkOOOO000OOOOOOkxdlc::;,,..':ccc::ldOKK0000000000000000000000000000000000000000OOOOOOOOOOOOO\r\n"
					+ "kkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO0O000Okc....',;:cclcc:::::::;,,,,,,;;:cclloolllllodxxkOOOOOO00OOOOkkkdoolc:;,,...;oddl:::cx0KK000000000000000000000000000000000000000000OOOOOOOOOO\r\n"
					+ "kkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOO00000O00O0kc'....',;:clllccccllllllccc::::ccllooooooddxxkkkOOOO00OOOOkxdolll::;,'.':dxkkd:;;:lk0KKK00000000000000000000000000000000000000000OOOOOOOOO\r\n"
					+ "xkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOO000000O0000Okl,.....',;:cllllllloooollllllcllllllloooooddxkkOOOOOO0OOkxdolccc:;,'',:dkOOOx:',,:oOKKXKK000000000000000000000000000000000000000000OOOOOO\r\n"
					+ "xkkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOO0000000000000OOd;......',;:cllllloooooolllccccccc::cccloddxkkOOOOOO0Okkdlcc:::;,'';coxkOOOxc...,cxOKXXXKK000000000000000000000000000000000000000000OOOO\r\n"
					+ "xkkkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOO0000000000000000000kc'......',;:clcllooooooollccccc:::::loxxkkOOO00OO00Okxdlc:;;;,'';oxkOOOOOkd:...;ok0KXXXXKK00K0000000000000000000000000000000000000OOOO\r\n"
					+ "xxkkkkkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOO00000000000000000000Od:.......',;:::clloooooooooooooollodxkkOOO0000000OOkxoc::,',',:lxkOOOOOOOkd:'.,lxk0XXXXXKKK000KK000000000000000000000000000000000OOOO\r\n"
					+ "xxxxxkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOO0000000000000000000000OOkl,.......',,;::cllooodddddxxxxxxkkkkOOOOOO00OOOOkkdl:;,,'';loxkOOOOOOOOkxo:''cdk0KXXXXXXKK00KKKKK0000000000000000000000000000000OOO\r\n"
					+ "xxxxxxkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOO0000000000000000000000000Oxl,......'''',;::cloddddxxxxxxkkkkkkkkOOOOOOkkxxxdoc:,''':oxkkOOOOOOOOOkkdl;';oxOKXXXXXXXKKKKKKKKK0000000000000000000000000000000OO\r\n"
					+ "xxxxxxxkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOO0000000000000000000000000Oxc,'.........',,;:clooddddddxxxxxxxxxxxxxdddddoollc;,'',ldkkkkOOOOOOOOOkxxdc,'cdOKXXXXXXXXXXKKKKKKKKK000000000000000000000000000000\r\n"
					+ "xxxxxxxkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOO0000000000000000000000000Oxo:,'..','.....''';;::clooooooddddddolcclllccccc:::,'';coxkkkkOOOOOOOOOkkxxdl;';dOKXXXXXXXXXXXXXXXXXXKKKKK00000000000000000000000000\r\n"
					+ "xxxxxxxkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOO0000000000000000000000OOOkdc;,,...:c:,......'',,;;::cccclllllc:;,,;::;;,,;;,,',:oxxkkkOOOOOOOOOOOkkxxdl;';dOKXXXXNXXXXXXXXXXXXXXXKKKKK000000000000000000000000\r\n"
					+ "xxxxxxxkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOO000000000000OOOOOOOOOOOOOkdc;,,. .;cc:;'.......''',,,,;;;;;;;;,'.'''''..'',;;codxkkkOOOOOOOOOOOOOkxxdol:,cxOKXXNXNXXNNXXXXXXXXXXKXXXXKKKKKK0000000000000000000\r\n"
					+ "xxxxxxxkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOO0000OOOOOOOOOOOOOOOOOOOO0Okdc;,'. .':clcc:,......''.''''''..............';clodxxxkkOOOOOOOOOOOOOOkkxddoc;;okOKXNNNNNXNNNNNNXXXXXXXXXXXXXXKKKKKKKKK0000000000000\r\n"
					+ "xxxxxxxxkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO00Okdc;;'.  .,:clllc::;;,''................'',;::clodxkkkkkOOOOOOOOOOOOOOOkxxdol:,;dkO0XXNNNNNNNNNNNNXXXXXXXXXXXXXXXXXXXXKKKKK0000000000\r\n"
					+ "xxxxxxxxkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOOOOOOOOOkkkOOOOkkkkOOOO000Okxoc;.. ..';:cllllllllc:;,,,',,,,,,'',,;cloooooddxkkkOOOOOOOOOOOOOOOOOOkxddoc;,cxOO0XXNNNNNNNNNNNNNXXXXXXXXXXXXXXXXXXXKKKKKKKK0000000\r\n"
					+ "xxxxxxxxkkkkkkkkkkkkkkkOOOOOOOOOOOOOOOOOkkOOOOOOOkkOOOkkkkkOOOO0000Okxdc.  ...';:clllooooollc::::;:::::::ccodddddddxkkOOOOOOOOOOOOOOOOOOOkkxddlc,,lkO0KXXNNNNNNNNNNNNNXXXXXXXXXXXXXXXXXXKKKKKXXKKKKK0000\r\n"
					+ "");
			System.out.println("Bienvenue tapoteur.euse. \n");
			System.out.println("1 - Je me présente à toi, JAVA");
			System.out.println("2 - Je reviendrai plus tard à toi, JAVA");
			
			int choix = saisieInt("Choisis ta voie");
			switch(choix)
			{
			case 1 : loginMenu();break;
			case 2 : System.exit(0);
			}		
			mainMenu();
		}
		
		public static void loginMenu()
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			
			//connected = daoT.findByLoginAndPassword(login, password);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public static void main(String[] args) {	
		mainMenu();
		
		
		//Create bdd
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		emf.close();
	}
}
