import resolve from "rollup-plugin-node-resolve";
import commonjs from "rollup-plugin-commonjs";
import scss from "rollup-plugin-scss"
import { terser } from "rollup-plugin-terser";

export default [
	// browser-friendly UMD build
	{
		input: "src/main.js",
		output: {
			name: "main",
			file: "dist/main.js",
			format: "umd"
		},
		plugins: [
			resolve(), // resolve node_modules
			commonjs() , // create ES modules
			scss({
			    outputStyle: "compressed",
			    sourceMap: "dist/main.css",
            }), // SCSS and CSS
			terser({
			    sourcemap: {
			        filename: "main.js",
                    url: "main.js.map"
			    }
            }),
		]
	}
];
