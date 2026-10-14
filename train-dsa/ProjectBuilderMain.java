import java.time.LocalDate;

class Project {

    String projectName;
    String projectPath;
    String  projectType;
    LocalDate createdDate;
    LocalDate lastModifiedDate;


    private Project(Builder projectBuilder) {
        this.projectName = projectBuilder.projectName;
        this.projectPath = projectBuilder.projectPath;
        this.projectType = projectBuilder.projectType;
        this.createdDate = projectBuilder.createdDate;
        this.lastModifiedDate = projectBuilder.lastModifiedDate;
    }

    public static class Builder {
        String projectName;
        String projectPath;
        String  projectType;
        LocalDate createdDate;
        LocalDate lastModifiedDate;

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder projectPath(String projectPath) {
            this.projectPath = projectPath;
            return this;
        }

        public Builder projectType(String projectType) {
            this.projectType = projectType;
            return this;
        }

        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder lastModifiedDate(LocalDate lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }   
}

public class ProjectBuilderMain {

    public static void main(String[] args) {
        Project project = new Project.Builder()
                .projectName("MyProject")
                .projectPath("/path/to/project")
                .projectType("Java")
                .createdDate(LocalDate.now())
                .lastModifiedDate(LocalDate.now())
                .build();

        System.out.println("Project Name: " + project.projectName);
        System.out.println("Project Path: " + project.projectPath);
        System.out.println("Project Type: " + project.projectType);
        System.out.println("Created Date: " + project.createdDate);
        System.out.println("Last Modified Date: " + project.lastModifiedDate);
    }
}
