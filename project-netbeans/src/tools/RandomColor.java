package tools;
import java.awt.Color;
import java.util.Random;

public class RandomColor {


	// ======== getLight ===========
	public static Color getLight(){

		Random r = new Random();
		String code=lightColor[r.nextInt(lightColor.length)];
		Color lightColor=Color.decode(code);
		return lightColor;
	}

	// ======== getDeep ===========
	public static Color getDeep(){

		Random r = new Random();
		String code=deepColor[r.nextInt(deepColor.length)];
		Color deepColor=Color.decode(code);
		return deepColor;
	}



	public static String[] deepColor = new String[] {

		"#693768",
		"#69374F",
		"#695137",
		"#383769",
		"#511789",
		"#181789",
		"#A00200",
		"#004EA0",
		"#693768",
		"#693837"
	};


	public static String[] lightColor = new String[] {

		"#FFCDFE",
		"#FFAFD6",
		"#FFB0AF",
		"#FFC991",
		"#C7FF91",
		"#91FFC9",
		"#91C7FF",
		"#EFC9A1",
		"#EAEB87",
		"#A1EFA2",
		"#BAF3F4",
		"#A1EFC9",
		"#C68EC5",
		"#D0A3A2",
		"#B6DAC8",
		"#B6C8DA",
		"#FEFF91",
		"#C8B6DA",
		"#FFAFD6",
		"#73FDFF"

	};




}
