public class EducationMapper {

    public static void main(String[] args) {
        System.out.print(educationalLevelMapper(getfleschIndex(
                "Hi therer gfhfghgfh./fgh',.")));
    }

    private static double getFindex(String preview_description) {
        double words = 0;
        double syllables = 0;
        double sentences = 0;
        int counter = 1;
        while (preview_description.indexOf(" ", counter) != -1) {
            counter = preview_description.indexOf(" ", counter) + 1;
            words++;
        }
        words++;
        counter = 0;

        while (preview_description.indexOf(".", counter) != -1) {
            counter = preview_description.indexOf(".", counter) + 1;
            sentences++;
        }
        counter = 0;

        if (preview_description == "" || words == 0) {
            return 999;
        }
        return 206.835 - 84.6 * (syllables / words) - 1.015 * (words / sentences);
    }

    public static String educationalLevelMapper(double fIndex) {
        if (fIndex <= 0)
            return "Law School Graduate";
        else if (fIndex <= 30 && fIndex > 0)
            return "College Graduate";
        else if (fIndex <= 51 && fIndex > 31)
            return "Some College";
        else if (fIndex <= 61 && fIndex > 51)
            return "High School";
        else if (fIndex <= 66 && fIndex > 61)
            return "9th Grade";
        else if (fIndex <= 71 && fIndex > 66)
            return "8th Grade";
        else if (fIndex <= 81 && fIndex > 71)
            return "7th Grade";
        else if (fIndex <= 81 && fIndex > 81)
            return "6th Grade";
        else if (fIndex <= 100 && fIndex > 91)
            return "5th Grade";
        else if (fIndex > 100)
            return "Early";
        return "Unable to Compute";
    }
}
