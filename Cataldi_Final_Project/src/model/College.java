package model;

public class College
{
    private StudentBag studentBag;
    private FacultyBag facultyBag;
    private CourseBag courseBag;
    private TextbookBag textbookBag;
    private ClassroomBag classroomBag;
    private MiniStudentCourseBag miniStudentCourseBag;
    
    public College()
    {
        studentBag = new StudentBag(CollegeInterface.STUDENTBAG_MAXSIZE);
        facultyBag = new FacultyBag(CollegeInterface.FACULTYBAG_MAXSIZE);
        courseBag = new CourseBag(CollegeInterface.COURSEBAG_MAXSIZE);
        textbookBag = new TextbookBag(CollegeInterface.TEXTBOOKBAG_MAXSIZE);
        classroomBag = new ClassroomBag(CollegeInterface.CLASSROOM_MAXSIZE);
        miniStudentCourseBag = new MiniStudentCourseBag(CollegeInterface.MINISTUDENTCOURSEBAG_MAXSIZE);
    }

    
    public StudentBag getStudentBag()
    {
        return studentBag;
    }  
    public void setStudentBag(StudentBag studentBag)
    {
        this.studentBag = studentBag;
    }
    
    
    public FacultyBag getFacultyBag()
    {
        return facultyBag;
    }  
    public void setFacultyBag(FacultyBag facultyBag)
    {
        this.facultyBag = facultyBag;
    }

    
    public CourseBag getCourseBag()
    {
        return courseBag;
    }   
    public void setCourseBag(CourseBag courseBag)
    {
        this.courseBag = courseBag;
    }
    
    
    public TextbookBag getTextbookBag()
    {
        return textbookBag;
    }   
    public void setTextbookBag(TextbookBag textbookBag)
    {
        this.textbookBag = textbookBag;
    }
    
    
    public ClassroomBag getClassroomBag()
    {
        return classroomBag;
    }   
    public void setClassroomBag(ClassroomBag classroomBag)
    {
        this.classroomBag = classroomBag;
    }


    public MiniStudentCourseBag getMiniStudentCourseBag()
    {
        return miniStudentCourseBag;
    } 
    public void setMiniStudentCourseBag(MiniStudentCourseBag miniStudentCourseBag)
    {
        this.miniStudentCourseBag = miniStudentCourseBag;
    }
}
