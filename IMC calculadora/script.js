function calcularIMC() {
  const peso = parseFloat(document.getElementById('peso').value);
  const altura = parseFloat(document.getElementById('altura').value);
  const resultado = document.getElementById('resultado');

  if (!peso || !altura || altura <= 0) {
    resultado.textContent = "Por favor, insira valores válidos.";
    return;
  }

  const imc = peso / (altura * altura);
  let classificacao = "";

  if (imc < 18.5) classificacao = "Abaixo do peso";
  else if (imc < 24.9) classificacao = "Peso normal";
  else if (imc < 29.9) classificacao = "Sobrepeso";
  else if (imc < 34.9) classificacao = "Obesidade grau I";
  else if (imc < 39.9) classificacao = "Obesidade grau II";
  else classificacao = "Obesidade grau III (mórbida)";

  resultado.textContent = `Seu IMC é ${imc.toFixed(2)} (${classificacao})`;
}