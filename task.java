public class task {
    public String Text;
    public int Length;
    public int Priority;
    public int Start;

    public task(String Text, int Length, int Priority){
        this.Text = Text;
        this.Length = Length;
        this.Priority = Priority;
    }

    public String toString(){
        return String.format("%s: %dhrs %d", Text, Length, Priority);
    }

    public String toFormattedString(){
        StringBuilder s = new StringBuilder("╓────\n║"+this.toString());
        for (int i=1; i<Length; i++){
            s.append("\n║");
        }
        //s.append("\n╙────");
        return s.toString();
    }
}
