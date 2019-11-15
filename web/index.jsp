<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 12.11.2019
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>MY STUPID PAGE</title>
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  </head>
  <body>
  <table id="main">
    <tbody>
    <tr>
      <th id="cap" colspan="2">
        Лабораторная №2 Вариант 45479
        <br>Никольская Дарья Владимировна
        <br>группа P3211
      </th>
    </tr>
    <tr>
      <th class="column">
        <canvas id="canvas" width="300" height="300"></canvas>
        <fieldset>
          <legend>Введите пераметр и координаты точки</legend>
          <form action="" method="get" onsubmit="return val()">
            <table width="100%">
              <tbody>
              <tr>
                <td>
                  <label for="x">Изменение X:</label>
                </td>
                <td>
                  <select id="x" name="x" class="input" size="1" style="width: 70%;">
                   <!-- <option selected="" disabled="">выберите значение</option> -->
                    <option>-5</option>
                    <option>-4</option>
                    <option>-3</option>
                    <option>-2</option>
                    <option>-1</option>
                    <option selected="">0</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                  </select>
                </td>
              </tr>
              <tr>
                <td>
                  <label for="y">Изменение Y:</label>
                </td>
                <td>
                  <input type="text" class="input" id="y" name="y" maxlength="10" placeholder="should be in (-3..5)" style="width: 70%;"> </td>
              </tr>
              <tr>
                <td>
                  <label for="r">Изменение R:</label>
                </td>
                <td>
                  <select id="r" name="r" class="input" onchange="selectedR();" size="1" style="width: 70%;">
                    <!-- <option selected="" disabled="">выберите значение</option> -->
                    <option selected ="">1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <input type="submit" name="submit"> </td>
              </tr>
              </tbody>
            </table>
          </form>
        </fieldset>
      </th>

      <th class="column">
        <div class="kek">
          <script src="${pageContext.request.contextPath}/script.js"></script>
          <table id="result" onchange="redrawCanvas()"></table>
        </div>

      </th>
    </tr>
    </tbody>
  </table>
  </body>
</html>
