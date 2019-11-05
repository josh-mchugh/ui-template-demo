const gulp = require("gulp");
const webpack = require("webpack");
const gulpWebpack = require("webpack-stream");
const del = require("del");

gulp.task("clean", function() {
    return del("dist/**", {force:true});
});

gulp.task("webpack", function() {
  return gulp.src("./src/scripts/main.js")
    .pipe(gulpWebpack(require("./webpack/webpack.config.prod.js"), webpack))
    .pipe(gulp.dest("dist/"));
});

gulp.task("copy", function() {
    return gulp.src("./dist/**")
        .pipe(gulp.dest("../src/main/resources/public"));
});

gulp.task("build", gulp.series(
    "clean",
    "webpack",
    "copy"
));