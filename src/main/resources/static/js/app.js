let seconds = 0;

function updateUptime() {

    seconds++;

    const hours = Math.floor(seconds / 3600);
    const minutes = Math.floor((seconds % 3600) / 60);
    const secs = seconds % 60;

    const formatted =
        String(hours).padStart(2, '0') + ":" +
        String(minutes).padStart(2, '0') + ":" +
        String(secs).padStart(2, '0');

    document.getElementById("uptime").textContent = formatted;
}


async function loadStatus() {

    try {

        const response = await fetch("/api/status");

        const data = await response.json();

        console.log("Application status:", data);

    } catch (error) {

        console.error("Unable to load application status:", error);

    }

}


setInterval(updateUptime, 1000);

loadStatus();