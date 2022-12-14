const Path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');

module.exports = {
  entry: {
    main: Path.resolve(__dirname, '../src/scripts/main.js'),
    vendor: Path.resolve(__dirname, '../src/scripts/vendor.js')
  },
  output: {
    path: Path.join(__dirname, '../dist'),
    filename: 'js/[name].js'
  },
  optimization: {},
  plugins: [
    new CleanWebpackPlugin(),
    new webpack.ProvidePlugin({
        $: 'jquery',
        jQuery: 'jquery',
        'window.jQuery': 'jquery',
    }),
  ],
  resolve: {
    alias: {
      '~': Path.resolve(__dirname, '../src'),
      'fomantic': Path.resolve(__dirname, '../fomantic/dist')
    }
  },
  module: {
    rules: [
      {
        test: /\.mjs$/,
        include: /node_modules/,
        type: 'javascript/auto'
      },
      {
        test: /\.(ico|jpg|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2)(\?.*)?$/,
        use: {
          loader: 'file-loader',
          options: {
            name: '[path][name].[ext]'
          }
        }
      },
    ]
  }
};
