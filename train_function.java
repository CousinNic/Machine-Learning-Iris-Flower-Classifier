import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * class to use data to train, then calculated the most probable 
 * flower type from example data
 * requires iris.txt to read
 * @author Nic Drummey
 * Date: 4-18-2022
 */
public class train_function {
	// to store the amount of occurinces of each value
	static String data[] = new String[150];

	static double setosa = (double) 1 / 3;
	static double setOneMean;
	static double setTwoMean;
	static double setThreeMean;
	static double setFourMean;
	static double setOneDev;
	static double setTwoDev;
	static double setThreeDev;
	static double setFourDev;

	static double versicolor = (double) 1 / 3;
	static double verOneMean;
	static double verTwoMean;
	static double verThreeMean;
	static double verFourMean;
	static double verOneDev;
	static double verTwoDev;
	static double verThreeDev;
	static double verFourDev;

	static double virginica = (double) 1 / 3;
	static double virOneMean;
	static double virTwoMean;
	static double virThreeMean;
	static double virFourMean;
	static double virOneDev;
	static double virTwoDev;
	static double virThreeDev;
	static double virFourDev;

	static double isSet = 1;
	static double isVer = 1;
	static double isVir = 1;

	/**
	 * Main method to use data to train, then calculated the most probable 
 	 * flower type from example data
	 */
	public static void main(String[] args) {
		double[] record1 = { 4.3, 2.7, 4.9, 0.8 };
		double[] record2 = { 7.7, 3.3, 5.7, 2.1 };
		double[] record3 = { 9.2, 3.2, 6.0, 0.3 };
		double[] record4 = { 3.2, 2.8, 4.8, 2.8 };
		double[] record5 = { 4.1, 3.0, 4.9, 1.9 };

		// opens file and passes to train
		File file = new File("iris.data");
		train(file);

		// runs classifier with record values
		System.out.println("Data [4.3,2.7,4.9,0.8]");
		System.out.println("Classifies as: " + classifier(record1));
		System.out.println("Data [7.7,3.3,5.7,2.1]");
		System.out.println("Classifies as: " + classifier(record2));
		System.out.println("Data [9.2,3.2,6.0,0.3]");
		System.out.println("Classifies as: " + classifier(record3));
		System.out.println("Data [3.2,2.8,4.8,2.8]");
		System.out.println("Classifies as: " + classifier(record4));
		System.out.println("Data [4.1,3.0,4.9,1.9]");
		System.out.println("Classifies as: " + classifier(record5));
	}
	/**
	 * classifies example data based on the train data
	 */
	static String classifier(double[] record) {
		double tempSet = 1;
		double tempVer = 1;
		double tempVir = 1;

		// the algorithm i wish didnt exist
		// calculate probability of setosa
		isSet = Math.sqrt(2 * Math.PI * Math.pow(setOneDev, 2));
		isSet = Math.log(
				1 / (isSet) * Math.pow(Math.E, -Math.pow((record[0] - setOneMean), 2) / (2 * Math.pow(setOneDev, 2))));

		tempSet = Math.sqrt(2 * Math.PI * Math.pow(setTwoDev, 2));
		tempSet = 1 / (tempSet)
				* Math.pow(Math.E, -Math.pow((record[1] - setTwoMean), 2) / (2 * Math.pow(setTwoDev, 2)));
		isSet += Math.log(tempSet);

		tempSet = Math.sqrt(2 * Math.PI * Math.pow(setThreeDev, 2));
		tempSet = 1 / (tempSet)
				* Math.pow(Math.E, -Math.pow((record[2] - setThreeMean), 2) / (2 * Math.pow(setThreeDev, 2)));
		isSet += Math.log(tempSet);

		tempSet = Math.sqrt(2 * Math.PI * Math.pow(setFourDev, 2));
		tempSet = 1 / (tempSet)
				* Math.pow(Math.E, -Math.pow((record[3] - setFourMean), 2) / (2 * Math.pow(setFourDev, 2)));
		isSet += Math.log(tempSet);
		isSet += Math.log(setosa);

		// calculate probability of versicolor
		isVer = Math.sqrt(2 * Math.PI * Math.pow(verOneDev, 2));
		isVer = Math.log(
				1 / (isVer) * Math.pow(Math.E, -Math.pow((record[0] - verOneMean), 2) / (2 * Math.pow(verOneDev, 2))));

		tempVer = Math.sqrt(2 * Math.PI * Math.pow(verTwoDev, 2));
		tempVer = 1 / (tempVer)
				* Math.pow(Math.E, -Math.pow((record[1] - verTwoMean), 2) / (2 * Math.pow(verTwoDev, 2)));
		isVer += Math.log(tempVer);

		tempVer = Math.sqrt(2 * Math.PI * Math.pow(verThreeDev, 2));
		tempVer = 1 / (tempVer)
				* Math.pow(Math.E, -Math.pow((record[2] - verThreeMean), 2) / (2 * Math.pow(verThreeDev, 2)));
		isVer += Math.log(tempVer);

		tempVer = Math.sqrt(2 * Math.PI * Math.pow(verFourDev, 2));
		tempVer = 1 / (tempVer)
				* Math.pow(Math.E, -Math.pow((record[3] - verFourMean), 2) / (2 * Math.pow(verFourDev, 2)));
		isVer += Math.log(tempVer);
		isVer += Math.log(versicolor);

		// calculate probability of virginica
		isVir = Math.sqrt(2 * Math.PI * Math.pow(virOneDev, 2));
		isVir = Math.log(
				1 / (isVir) * Math.pow(Math.E, -Math.pow((record[0] - virOneMean), 2) / (2 * Math.pow(virOneDev, 2))));

		tempVir = Math.sqrt(2 * Math.PI * Math.pow(virOneDev, 2));
		tempVir = 1 / (tempVir)
				* Math.pow(Math.E, -Math.pow((record[1] - virTwoMean), 2) / (2 * Math.pow(virTwoDev, 2)));
		isVir += Math.log(tempVir);

		tempVir = Math.sqrt(2 * Math.PI * Math.pow(virOneDev, 2));
		tempVir = 1 / (tempVir)
				* Math.pow(Math.E, -Math.pow((record[2] - virThreeMean), 2) / (2 * Math.pow(virThreeDev, 2)));
		// System.out.println(isVir);
		isVir += Math.log(tempVir);

		tempVir = Math.sqrt(2 * Math.PI * Math.pow(virOneDev, 2));
		tempVir = 1 / (tempVir)
				* Math.pow(Math.E, -Math.pow((record[3] - virFourMean), 2) / (2 * Math.pow(virFourDev, 2)));
		isVir += Math.log(tempVir);
		isVir += Math.log(virginica);

		// check which probability is higher
		if ((isSet > isVer) && (isSet > isVir)) {
			return "Iris-Setosa";
		} else if ((isVer > isSet) && (isVer > isVir)) {
			return "Iris-Versicolor";
		} else if ((isVir > isSet) && (isVir > isVer)) {
			return "Iris-Virginica";
		} else
			return "";

	}
	/**
	 * class to train the function based on the iris.data
	 */
	static void train(File file) {
		// reds file line by line
		int t = 0;
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String d = sc.nextLine();
				// System.out.println(data);
				if (!d.isEmpty())
					//save each line to string array
					data[t] = d;
				t++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find ["+file+"]");
			System.exit(0);			
		}
		// System.out.println(data[1]);
		for (int i = 0; i < 150; i++)
			assignMean(data[i]);

		// finalizes mean calculation
		// prints are for testing
		setOneMean = setOneMean / 50;
		// System.out.println(setOneMean);
		setTwoMean = setTwoMean / 50;
		// System.out.println(setTwoMean);
		setThreeMean = setThreeMean / 50;
		// System.out.println(setThreeMean);
		setFourMean = setFourMean / 50;
		// System.out.println(setFourMean);

		verOneMean = verOneMean / 50;
		// System.out.println(verOneMean);
		verTwoMean = verTwoMean / 50;
		// System.out.println(verTwoMean);
		verThreeMean = verThreeMean / 50;
		// System.out.println(verThreeMean);
		verFourMean = verFourMean / 50;
		// System.out.println(verFourMean);

		virOneMean = virOneMean / 50;
		// System.out.println(virOneMean);
		virTwoMean = virTwoMean / 50;
		// System.out.println(virTwoMean);
		virThreeMean = virThreeMean / 50;
		// System.out.println(virThreeMean);
		virFourMean = virFourMean / 50;
		// System.out.println(virFourMean);

		for (int i = 0; i < 150; i++) {
			assignStdDev(data[i]);
		}
		// finalize Standard Deviation Calculation
		// prints are for testing
		setOneDev = setOneDev / 50;
		setOneDev = Math.sqrt(setOneDev);
		// System.out.println(setOneDev);
		setTwoDev = setTwoDev / 50;
		setTwoDev = Math.sqrt(setTwoDev);
		// System.out.println(setTwoDev);
		setThreeDev = setThreeDev / 50;
		setThreeDev = Math.sqrt(setThreeDev);
		// System.out.println(setThreeDev);
		setFourDev = setFourDev / 50;
		setFourDev = Math.sqrt(setFourDev);
		// System.out.println(setFourDev);

		verOneDev = verOneDev / 50;
		verOneDev = Math.sqrt(verOneDev);
		// System.out.println(verOneDev);
		verTwoDev = verTwoDev / 50;
		verTwoDev = Math.sqrt(verTwoDev);
		// System.out.println(verTwoDev);
		verThreeDev = verThreeDev / 50;
		verThreeDev = Math.sqrt(verThreeDev);
		// System.out.println(verThreeDev);
		verFourDev = verFourDev / 50;
		verFourDev = Math.sqrt(verFourDev);
		// System.out.println(verFourDev);

		virOneDev = virOneDev / 50;
		virOneDev = Math.sqrt(virOneDev);
		// System.out.println(virOneDev);
		virTwoDev = virTwoDev / 50;
		virTwoDev = Math.sqrt(virTwoDev);
		// System.out.println(virTwoDev);
		virThreeDev = virThreeDev / 50;
		virThreeDev = Math.sqrt(virThreeDev);
		// System.out.println(virThreeDev);
		virFourDev = virFourDev / 50;
		virFourDev = Math.sqrt(virFourDev);
		// System.out.println(virFourDev);

	}
	/**
	 * class to assign Standard Deviation 
	 */
	static void assignStdDev(String d) {
		String[] split = d.split(",", 5);
		// System.out.println(split[4]);
		if (split[4].contains("setosa"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					setOneDev += Math.pow((Double.valueOf(split[i]) - setOneMean), 2);
				} else if (i == 1) {
					setTwoDev += Math.pow((Double.valueOf(split[i]) - setTwoMean), 2);
				} else if (i == 2) {
					setThreeDev += Math.pow((Double.valueOf(split[i]) - setThreeMean), 2);
				} else if (i == 3) {
					setFourDev += Math.pow((Double.valueOf(split[i]) - setFourMean), 2);
				}

			}
		if (split[4].contains("versicolor"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					verOneDev += Math.pow((Double.valueOf(split[i]) - verOneMean), 2);
				} else if (i == 1) {
					verTwoDev += Math.pow((Double.valueOf(split[i]) - verTwoMean), 2);
				} else if (i == 2) {
					verThreeDev += Math.pow((Double.valueOf(split[i]) - verThreeMean), 2);
				} else if (i == 3) {
					verFourDev += Math.pow((Double.valueOf(split[i]) - verFourMean), 2);
				}

			}
		if (split[4].contains("virginica"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					virOneDev += Math.pow((Double.valueOf(split[i]) - virOneMean), 2);
				} else if (i == 1) {
					virTwoDev += Math.pow((Double.valueOf(split[i]) - virTwoMean), 2);
				} else if (i == 2) {
					virThreeDev += Math.pow((Double.valueOf(split[i]) - virThreeMean), 2);
				} else if (i == 3) {
					virFourDev += Math.pow((Double.valueOf(split[i]) - virFourMean), 2);
				}

			}
	}
	/**
	 * class to assign mean value
	 */
	static void assignMean(String d) {
		String[] split = d.split(",", 5);
		// System.out.println(split[4]);
		if (split[4].contains("setosa"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					setOneMean += Double.valueOf(split[i]);
				} else if (i == 1) {
					setTwoMean += Double.valueOf(split[i]);
				} else if (i == 2) {
					setThreeMean += Double.valueOf(split[i]);
				} else if (i == 3) {
					setFourMean += Double.valueOf(split[i]);
				}

			}
		if (split[4].contains("versicolor"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					verOneMean += Double.valueOf(split[i]);
				} else if (i == 1) {
					verTwoMean += Double.valueOf(split[i]);
				} else if (i == 2) {
					verThreeMean += Double.valueOf(split[i]);
				} else if (i == 3) {
					verFourMean += Double.valueOf(split[i]);
				}
			}
		if (split[4].contains("virginica"))
			for (int i = 0; i < 4; i++) {
				if (i == 0) {
					virOneMean += Double.valueOf(split[i]);
				} else if (i == 1) {
					virTwoMean += Double.valueOf(split[i]);
				} else if (i == 2) {
					virThreeMean += Double.valueOf(split[i]);
				} else if (i == 3) {
					virFourMean += Double.valueOf(split[i]);
				}
			}

	}

}
