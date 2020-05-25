/**
 * 普通车牌号：
    1位省份汉字 + 1位发牌号机关代号(只能是大写字母A-Z) + 5个数字或字母组合（不含字母I和O，防止与数字1和0混淆），最后一位可能是“挂学警港澳使领”中的一个汉字
 * 新能源车牌：比普通车牌号多一位
 * @param vehicleNumber
 * @returns {boolean}
 */

function isVehicleNumber(vehicleNumber) {
    var result = false;
    if (vehicleNumber.length == 7){
        var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        result = express.test(vehicleNumber);
    }
    return result;
}

console.log(isVehicleNumber("京Z00121"));
console.log(isVehicleNumber("京Z0"));



