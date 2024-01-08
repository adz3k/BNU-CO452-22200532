const dino = document.getElementById('dino');
const cactus = document.getElementById('cactus');
const timerSpan = document.getElementById('time');
let startTime;
let cactusLives = 3; // shows cactus lives

function jump() {
  // Function to handle the dinosaur jump
  if (dino.classList != 'jump') {
    dino.classList.add('jump');

    // Remove the jump class after 300 milliseconds
    setTimeout(function () {
      dino.classList.remove('jump');
    }, 300);
  }
}

let isAlive = setInterval(function () {
  // Get current dinosaur Y position
  let dinoTop = parseInt(window.getComputedStyle(dino).getPropertyValue('top'));

  // Get current cactus X position
  let cactusLeft = parseInt(window.getComputedStyle(cactus).getPropertyValue('left'));

  // Detect collision
  if (cactusLeft < 50 && cactusLeft > 0 && dinoTop >= 140) {
    // Collision with cactus
    if (cactusLives > 0) {
      // Decrease cactus lives and alert the remaining lives
      cactusLives--;
      alert(`Cactus hit! Lives remaining: ${cactusLives}`);
      resetGame(); // Reset the game state
    } else {
      //  displays the No lives remaining, game over when game ends
      alert('Game Over!');
      clearInterval(isAlive); // Stop the game loop
    }
  }
}, 10);

document.addEventListener('keydown', function (event) {
  // Event listener for dinosaur jump on key press
  jump();
});

function startGame() {
  // Function to start the game and and starts the timer
  startTime = Date.now();
  setInterval(updateTimer, 1000);
}

function updateTimer() {
  // Function to update the game timer
  const currentTime = Math.floor((Date.now() - startTime) / 1000);
  timerSpan.textContent = `${currentTime}s`;
}

function resetGame() {
  // Function to reset the game state when the game ends
  // Reset cactus position to the starting point when you die
  cactus.style.left = '580px';
}

startGame(); // Start the game when the script is loaded
