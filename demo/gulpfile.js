const gulp = require("gulp");
const sass = require("gulp-sass");
const autoprefixer = require("gulp-autoprefixer");
const cssbeautify = require("gulp-cssbeautify");
const htmlbeautify = require('gulp-html-beautify');
const nunjucksRender = require("gulp-nunjucks-render");
const browserSync = require("browser-sync").create();

gulp.task("scss", function () {
   return gulp.src("src/scss/**/*.scss")
          .pipe(sass())
          .pipe(autoprefixer())
          .pipe(cssbeautify())
          .pipe(browserSync.reload( { stream:true } ))
          .pipe(gulp.dest("dist/css"))
});

gulp.task("html", function(){
   return gulp.src('src/**/*.html')
       .pipe(nunjucksRender( { path: ['src/templates'] }))
       .pipe(htmlbeautify())
       .pipe(gulp.dest("dist"));
});

gulp.task("js", function() {
    return gulp.src("src/js/*.js")
        .pipe(gulp.dest("dist/js"));
});

gulp.task("assets", function() {
    return gulp.src("src/assets/**/*")
        .pipe(gulp.dest("dist/assets"));
});

gulp.task("build", gulp.parallel(
    "scss",
    "html",
    "js",
    "assets"
));

gulp.task("server", function(){
     browserSync.init({
         server: "./dist",
         port: 4000
     });
})

gulp.task("reload", function(done){
    browserSync.reload();
    done();
});

gulp.task("watch", function() {
    gulp.watch("src", gulp.series("build", "reload"));
});

gulp.task("serve", gulp.series(
    "build",
    gulp.parallel("server", "watch")
));